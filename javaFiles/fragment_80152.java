int lastLocation = 0;
Point[] points = new Point[10];
PointerInfo pointer = MouseInfo.getPointerInfo();
Point point = pointer.getLocation();
points[lastLocation] = point;
lastLocaiton++;