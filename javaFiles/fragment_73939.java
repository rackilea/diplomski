void tree2(float x, float y, float z, float rx, float ry, float rz, float r, float h){

  //assume current origin is at bottom of box

  //rotate around bottom
  rotateX(rx);
  rotateY(ry);
  rotateZ(rz);

  //move to center
  translate(0,-h/2,0);

  //draw the box
  box(r,h,r);

  //move origin to the top of the box- the bottom of the next box
  translate(0,-h/2,0);

  //draw the next box
  if(r>10){
    tree2(x+h*sin(rx)*sin(ry)*cos(rz)+h*cos(rx)*sin(rz),y-h*sin(rx)*sin(ry)*sin(rz)+h*cos(rx)*cos(rz),z-h*sin(rx)*cos(ry),rx+deltaX,ry+deltaY,rz+deltaZ,r-4,h-5);
  }
}