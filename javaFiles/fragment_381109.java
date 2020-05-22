public void tick() {
  time += 1.0 / 60.0;
  if (x <= 0) {
    xreflection = 1.0;
  } else if (x >= Game.Width - 15) {
    xreflection = -1.0;
  }
  if (y <= 0) {
    yreflection = 1.0;
  } else if (y >= Game.Height - 15) {
    yreflection = -1.0;
  }
  x += traj.xvel() * xreflection;
  y -= traj.yvel(time) * yreflection;
}