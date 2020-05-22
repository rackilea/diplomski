void CalculateBoundingBox( Polygon p, Point lowerRight, Point upperLeft )
{
    //Method to calculate the bounding box of this polyline
    int size = p.size();
    double xmin = /*infinity*/;
    double xmax = /*negative infinity*/;
    double ymin = xmin, ymax = xmax;

    for ( int i = 0; i < size; ++i )
    {
        if ( p[i].x < xmin )
            xmin = p[i].x;

        if ( p[i].y < ymin )
            ymin = p[i].y;

        if ( p[i].x > xmax )
            xmax = p[i].x;

        if ( p[i].y > ymax )
            ymax = p[i].y;
    }

    lowerRight.set( xmax, ymin );
    upperLeft.set( xmin, ymax );
}