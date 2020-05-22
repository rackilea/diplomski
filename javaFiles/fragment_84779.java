class Block {
  color c = color(random(255), random(255), random(255));
  float x = random(width);
  float speed = random(3, 6);
  void run() {
    float dir = mouseX - x;
    dir /= abs(dir);
    x += dir * speed;
  }
  void display() {
    fill(c);
    rect(x, 300, 30, 60);
  }
  void collide() {
    for (Block other : blocks) {
      if (other != this) {
        if (x + 30 > other.x && x + 30 <= other.x + 15) {
          x = other.x - 30;
        }
        else if (x < other.x + 30 && x > other.x + 15) {
          x = other.x + 30;
        }
      }
    }
  }
  void overlap() {
    for (Block other : blocks) {
      if (other != this) {
        if (x + 30 > other.x && x + 30 <= other.x + 30) {
          x = other.x - 30;
        }
      }
    }
  }
}
Block[] blocks = new Block[6];
void setup() {
  size(600, 600);
  for (int i = 0; i < blocks.length; i++) {
    blocks[i] = new Block();
  }
   for (Block b : blocks) {
     b.overlap();
   }
}
void draw() {
  background(255);
  for (Block b : blocks) {
   b.run();
   b.collide();
   b.display();
  }
}
void mousePressed() {
  setup();
}