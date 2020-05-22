double maxHeight = 0.0;

velocity = v;
angle = theta;

maxHeight = Math.pow(velocity, 2.0);
double sin = Math.sin(angle);
maxHeight *= Math.pow(sin, 2.0) / (2 * gravity);