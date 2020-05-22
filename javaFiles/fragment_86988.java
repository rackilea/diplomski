import hypermedia.video.*;
import SimpleOpenNI.*;

SimpleOpenNI  ni;
OpenCV cv;
PImage user;
void setup()
{
  ni = new SimpleOpenNI(this);
  ni.enableScene();
  background(200,0,0);
  strokeWeight(4);
  size(ni.sceneWidth() , ni.sceneHeight()); 
  cv = new OpenCV( this );
  cv.allocate(width,height);
}
void draw()
{
  //OpenNI
  ni.update();
  user = ni.sceneImage(); 
  //OpenCV
  cv.copy(user);
  cv.blur( OpenCV.BLUR, 17 );
  Blob[] blobs = cv.blobs( width,height, OpenCV.MAX_VERTICES, true, OpenCV.MAX_VERTICES*4 );

  //diplay
  image(cv.image(),0,0);
  //*
  fill(255);
  for(Blob b : blobs){
    beginShape();
      for(java.awt.Point p : b.points) vertex(p.x,p.y);
    endShape(CLOSE);
  }
  //*/
}