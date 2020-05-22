double t = 0;

Point prevPoint = CalculateBezierPoint(t, p0, p1, p2, p3);
for(int i = 0; i <= 100; i++)
{
  Point nextPoint = CalculateBezierPoint(t, p0, p1, p2, p3); //see this part from the link i have given

  //Draw line from previous point to next point.
  prevPoint = nextPoint;
  t = t + (1/100)    
}