boolean checked = false;

void mouseClicked(){
  checked = !checked;
}

void draw() {

  background(0);

  if (checked) {
    ellipse(50, 50, 20, 20);
  }
}