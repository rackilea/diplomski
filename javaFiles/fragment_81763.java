boolean bCircleShow=false;
int mx;
int my;
float opacity;
int diameter=0;
//
void setup () {
  size (400, 300);
  background (255);
  smooth ();
  opacity=255;
}
//
void draw() {
  background (122);
  //stroke (0, 255, 0);
  noStroke();
  fill(255);
  if (bCircleShow) {
    fill(255, 2, 2, opacity);
    ellipse (mx, my, diameter, diameter );
    diameter ++;
    opacity--;
    if (opacity<=0) {
      bCircleShow=false; // end
      opacity=255;
      diameter=0;
    }
  }
}
//
void mouseClicked() {
  bCircleShow=true;
  mx=mouseX;
  my=mouseY;
}