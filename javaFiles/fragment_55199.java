AnimationTimer timer = new AnimationTimer() {
    @Override
    public void handle(long now) {
        double delta = 0;

        if (goNorth) {
            delta += 5;
        }
        if (goSouth) {
            delta -= 5;
        }
        if (goEast) {
            rotate(3);
        }
        if (goWest) {
            rotate(-3);
        }

        Point2D pt = rotate.deltaTransform(initialDirection.multiply(delta));

        moveHeroBy(pt.getX(), pt.getY());
    }
};