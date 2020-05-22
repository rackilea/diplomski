if (ball.boundsIntersects(bricks.get(i)))
{
    ball.deltaY = -ball.deltaY;
    bricks.get(i).hide();
    bricks.remove(i);
    System.out.println("brick");
 }