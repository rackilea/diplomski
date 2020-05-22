import gab.opencv.*;
import processing.video.*;
import java.awt.*;

Capture video;
OpenCV opencv;

ArrayList<Contour> contours;
ArrayList<Contour> polygons;

int thresh = 70;

int time = millis();
int wait = 5000;

void setup() {
  size(640, 480);
  noFill();

  video = new Capture(this, 640/2, 480/2);
  //initialize OpenCV only once
  opencv = new OpenCV(this, 640/2, 480/2);

  video.start();
}

void draw() {
  scale(2);

  if (millis() - time >= wait){
    //update OpenCV with video feed
    opencv.loadImage(video);
    image(video, 0, 0 );

    time = millis();
    opencv.gray();
    opencv.threshold(thresh);
    contours = opencv.findContours();
    for (Contour contour : contours) {
      stroke(0, 255, 0);
      contour.draw();

      stroke(255, 0, 0);
      beginShape();
      for (PVector point : contour.getPolygonApproximation().getPoints()) {
        vertex(point.x, point.y);
      }
      endShape();
    }
  }
}
void mouseDragged(){
  thresh = (int)map(mouseX,0,width,0,255);
}
void captureEvent(Capture c) {
  c.read();
}