import javax.swing.JFrame;
void setup() {
  ((JFrame)frame).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
}
void draw() {
  background(0);
  ellipse(mouseX, mouseY, 10, 10);
}