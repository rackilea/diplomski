boolean drawText = false;

void draw() {
  background(0);
  if (drawText)
    text("word", 100, 100);
}

public void A() {
  drawText = true;
  println("This is a"); 
}

public void B() {
  drawText = false;
  println("This is b");
}