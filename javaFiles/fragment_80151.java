int lastLocation = 0;
int[] x = new int[10];
int[] y = new int[10];

PointerInfo pointer = MouseInfo.getPointerInfo();
Point point = pointer.getLocation();
x[lastLocation] = (int)point.getX();
y[lastLocation] = (int)point.getY();
lastLocation++;