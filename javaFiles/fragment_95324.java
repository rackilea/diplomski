private class Drawcirlce {
    public Paint myPaint;

    public void draw(Canvas c) { // Don't use a constructor here...
        if (myPaint == null)
            return;

        for (Point point : points) {
            c.drawCircle(point.x, point.y, 5, myPaint);
            invalidate();
        }
    }
}