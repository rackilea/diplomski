if (ball.boundsIntersects(bricks.get(i)))
{
    dY = -dY;
    ball.setLocation(dX,dY);
    bricks.get(i).hide();
    bricks.remove(i);
    System.out.println("brick");
 }