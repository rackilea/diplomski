Vector2 v = new Vector2( 1,0 );

Random rnd = new Random();
double rotationAngle = 2.0 * Math.PI * rnd.nextDouble();

Vector2 vRotated = new Vector2( 
   (v.x)*Math.cos(rotationAngle) + (v.y)*Math.sin(rotationAngle),
   (v.y)*Math.cos(rotationAngle) - (v.x)*Math.sin(rotationAngle)
);