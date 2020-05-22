private List<PointF> userPath = new ArrayList<PointF>();
pointF movingPoint = null; // change here
pointF initialPoint = new pointF();
initialPoint = (1,1);

for (i = 0; i < 5; i++)
{
    movingPoint = new pointF(); // change here

    movingPoint.x = initialPoint.x + i;
    movingPoint.y = initialPoint.y;

    userPath.add(movingPoint);
}