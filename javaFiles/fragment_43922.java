void display() { // display callback function
   glPushMatrix(); 
   glRotate(...); // rotation
   myObject.draw(); // draw the objects you want to rotate
   glPopMatrix();
}