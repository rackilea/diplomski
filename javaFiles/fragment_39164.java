static boolean lineSegmentsDoIntersect(
          float Ax, float Ay
        , float Bx, float By
        , float Cx, float Cy
        , float Dx, float Dy) {

    // two line segments: AB and CD
    // segment AB intersects segment CD
    // if  A and B on different sides of line through C and D
    // AND C and D on different sides of line through A and B

    // note the difference between line and  segment!

    if ( ! pointsOnDifferentSidesOfLineThrough(Ax, Ay, Bx, By, Cx, Cy, Dx, Dy) )
        return false;

    if ( ! pointsOnDifferentSidesOfLineThrough(Cx, Cy, Dx, Dy, Ax, Ay, Bx, By) )
        return false;

    return true;
}

static boolean pointsOnDifferentSidesOfLineThrough(
          float Ax, float Ay
        , float Bx, float By
        , float x1, float y1
        , float x2, float y2) {

    // determine equation of line through C and D

    // y = ax + b
    // a = (y2-y1)/(x2-x1)   but.. ( x2-x1) not equal to zero
    // y-y1 = a (x-x1)
    // y = a (x-x1) + y1
    // y = ax -ax1 + y1
    // b = -ax1 + y1

    //but.. (x2-x1) not 0

    if ( x2==x1)
    {
        if ( Ax > x1 && Bx > x1 )
            return false;
        if ( Ax < x1 && Bx < x1 )
            return false;

        return true;
    }

    float a = (y2-y1)/(x2-x1);
    float b = -a * x1 + y1;

    float yA = a * Ax + b;
    float yB = a * Bx + b;

    if ( yA > Ay && yB > By )
        return false;
    if ( yA < Ay && yB < By )
        return false;

    return true;
}