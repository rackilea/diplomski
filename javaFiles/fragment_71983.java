RunOverview thingy;
void setup(){}
void draw(){}
void registerOverview(RunOverview view){
  thingy = view;
}
void mousePressed(){
  thingy.mousePressed(mouseX,mouseY);
}
void mouseReleased(){
  thingy.mouseReleased(mouseX,mouseY);
}