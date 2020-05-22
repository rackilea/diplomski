public void run() {
    double firstBrick = (getWidth() - baseInPx) / 2;
    double baseHeight = getHeight();

    add(new GRect(firstBrick,baseHeight,BRICK_WIDTH, BRICK_HEIGHT));

}