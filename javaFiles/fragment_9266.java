void draw() {
  pushMatrix()
  translate(p.getPos().x+width/2,p.getPos().y+height/2); // <--Added Line
  background(200);

  //text(sw.second(),100,100);

  box2d.step();
  surface.display();
  popMatrix()
  time();
  keyTyped();

  box2d.setGravity(0, grav);

  p.display();
  prePos = p.getPos();
}