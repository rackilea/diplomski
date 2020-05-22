double angleInRadians = Math.toRadians(45);
double length = 100; 

double endX = Math.cos(angleInRadians) * length;
double endY = Math.sin(angleInRadians) * length;

LinearGradient lg = new LinearGradient(0, 0, endX, endY, ...);