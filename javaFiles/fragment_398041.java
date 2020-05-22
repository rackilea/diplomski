public void drawTree(Graphics g, int x, int y, int arity, int depth) {
    if (depth > 0) {
        int childDistanceX = (int) (Math.pow(arity, depth) * DISTANCE_X);
        int childX = x - (arity - 1) * childDistanceX / 2;
        int childY = y - DISTANCE_Y;

        for (int child = 0; child < arity; child++) {
            g.drawLine(x, y, childX, childY);
            drawTree(g, childX, childY, arity, depth - 1);
            childX += childDistanceX;
        }
    }
}