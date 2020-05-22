// heading (or course) [0, 2pi): 0 is up, rotation is clock-wise
// bearing (-pi, pi]: positive is clock-wise

// convert angle to (-pi, pi]
double norm(double a) {
  // do something smarter with modulus (%) here
  while (a <= -Math.PI) a += 2 * Math.PI;
  while (Math.PI < a) a -= 2 * Math.PI;
  return a;
}

// get bearing in radians to a target(x,y) from the current position/heading
double getBearing(int x, int y) {
  // can rotate the coordinate system to avoid the addition of pi/2 if you like 
  double b = Math.PI/2 - Math.atan2(y - robot.y(), x - robot.x());
  return norm(b - robot.getHeadingRadians());
}

// then bearing to centre is
double bearingToCentre = getBearing(xMiddle, yMiddle);