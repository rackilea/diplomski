private void checkBrick() {

    Rectangle b = new Rectangle(ball.getX(), ball.getY(), ball.getR(), ball.getR());

    for (int i = 0; i < 50; i++) {
        int tempX, tempY, tempW, tempH;
        tempX = bX[i];
        tempY = bY[i];
        tempW = bW[i];
        tempH = bH[i];

        Rectangle brick = new Rectangle(tempX, tempY, tempW, tempH);

        System.out.println("brick = " + brick);
        if (b.intersects(brick)) {
            System.out.println("Break");
        }
    }
}