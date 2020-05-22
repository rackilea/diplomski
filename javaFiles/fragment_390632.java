import processing.video.*;
import gab.opencv.*;

OpenCV opencv;

ArrayList<Contour> contours;

Capture theCap; 
Capture cam; 

boolean recording = false; 

int imageIndex = 0;

int time = millis();
int wait = 5000;

void setup(){
  size(640, 480);
  frameRate(30);
  background(0);
  noFill();

  String[] cameras = Capture.list();
  if (cameras.length == 0) {
    println("There are no cameras available for capture.");
    exit();
  } else {
    println("Available cameras:");
    for (int i = 0; i < cameras.length; i++) {
      println(cameras[i]);
    }
    cam = new Capture(this, cameras[0]);
    cam.start();  
  }
  //initialize OpenCV once, with size
  opencv = new OpenCV(this,640,480);
}

void draw(){
  if (millis() - time >= wait){
    time = millis(); 
    image(cam, 0, 0);
    if(cam.width > 0 && cam.height > 0){//check if the cam instance has loaded pixels
      opencv.loadImage(cam);//send the cam
      opencv.gray();
      opencv.threshold(70); 
      contours = opencv.findContours();

      for (Contour contour : contours) {
        stroke(0, 255, 0);
        contour.draw();
      }
    }
  }
}
void captureEvent(Capture c){
  c.read();
}