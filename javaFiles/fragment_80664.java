//TRANSLATE TO ORIGIN
double x1 = p1.getX() - center.x;
double y1 = p1.getY() - center.y;

//APPLY ROTATION
double temp_x1 = x1 * Math.cos(angle) - y1 * Math.sin(angle));
double temp_y1 = x1 * Math.sin(angle) + y1 * Math.cos(angle));

//TRANSLATE BACK
p1.setLocation(temp_x1 + center.x, temp_y1 + center.y);