ArrayList<SnowFlake> snowFlakes = new ArrayList<SnowFlake>();

void setup() {
  size(500, 500);

  for (int i = 0; i < 100; i++) {
    snowFlakes.add(new SnowFlake());
  }
}

void draw() {
  background(0);
  for (SnowFlake snowFlake : snowFlakes) {
    snowFlake.draw();
  }
}