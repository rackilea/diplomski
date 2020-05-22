float vx = destination.x - x;
float vy = destination.y - y;
for (float t = 0.0; t < 1.0; t+= step) {
  float next_point_x = x + vx*t;
  float next_point_y = y + vy*t;
  System.out.println(next_point_x + ", " + next_point_y);
}