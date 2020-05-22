private void checkBrick() {

    int tx = ball.getX();
    int ty = ball.getY();
    int tw = ball.getR();
    int th = ball.getR();

    tw += tx;
    th += ty;

    for (int i = 0; i < 50; i++) {
        int tempX, tempY, tempW, tempH;
        tempX = bX[i];
        tempY = bY[i];
        tempW = bW[i];
        tempH = bH[i];

        int rw = tempW + tempX;
        int rh = tempH + tempY;

        //     overflow || intersect
        if ((rw < tempX || rw > tx) &&
            (rh < tempY || rh > ty) &&
               (tw < tx || tw > tempX) &&
               (th < ty || th > tempY)) {
            System.out.println("Hit");
        }
    }
}