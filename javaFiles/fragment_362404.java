float getDistance(float startX, float startY, MotionEvent ev) {
    float distanceSum = 0;
    final int historySize = ev.getHistorySize();
    for (int h = 0; h < historySize; h++) {
        // historical point
        float hx = ev.getHistoricalX(0, h);
        float hy = ev.getHistoricalY(0, h);
        // distance between startX,startY and historical point
        float dx = (hx - startX);
        float dy = (hy - startY);
        distanceSum += Math.sqrt(dx * dx + dy * dy);
        // make historical point the start point for next loop iteration
        startX = hx;
        startY = hy;
    }
    // add distance from last historical point to event's point
    float dx = (ev.getX(0) - startX);
    float dy = (ev.getY(0) - startY);
    distanceSum += Math.sqrt(dx * dx + dy * dy);
    return distanceSum;
}