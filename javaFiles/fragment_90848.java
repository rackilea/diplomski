boolean isIntersect = false;
    for (Circle c : circles)
    {
        int x1 = c.getX();
        int y1 = c.getY();
        int R1 = c.getRadius();
        int distanceSq = (x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1);
        if (distanceSq <= (R0 + R1) * (R0 + R1))
        {
            isIntersect = true;
            break;
        }