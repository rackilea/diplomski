public boolean contains(int x, int y) {

    // Check if line is a point
    if(posX == endX && posY == endY){
        if(Math.abs(posY - y) <= lineThickness / 2 && Math.abs(posX - x) <= lineThickness / 2)
            return true;
        else
            return false;
    }

    int x1, x2, y1, y2;

    if(posX < endX){
        x1 = posX;
        y1 = posY;
        x2 = endX;
        y2 = endY;
    }
    else{
        x1 = endX;
        y1 = endY;
        x2 = posX;
        y2 = posY;
    }


    /**** USING MATRIX TRANSFORMATIONS ****/

    double r_numerator = (x-x1)*(x2-x1) + (y-y1)*(y2-y1);
    double r_denomenator = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
    double r = r_numerator / r_denomenator;

    // s is the position of the perpendicular projection of the point along
    // the line: s < 0 = point is left of the line; s > 0 = point is right of
    // the line; s = 0 = the point is along the line
    double s =  ((y1-y)*(x2-x1)-(x1-x)*(y2-y1) ) / r_denomenator;

    double distance = Math.abs(s)*Math.sqrt(r_denomenator);

    // Point is along the length of the line
    if ( (r >= 0) && (r <= 1) )
    {
            if(Math.abs(distance) <= lineThickness / 2){
                return true;
            }
            else
                return false;
    }
    // else point is at one end of the line
    else{
        double dist1 = (x-x1)*(x-x1) + (y-y1)*(y-y1); // distance to start of line
        double dist2 = (x-x2)*(x-x2) + (y-y2)*(y-y2); // distance to end of line
        if (dist1 < dist2){
            distance = Math.sqrt(dist1);
        }
        else{
            distance = Math.sqrt(dist2);
        }
        if(distance <= lineThickness / 2){
            return true;
        }
        else
            return false;
    }
    /**** END USING MATRIX TRANSFORMATIONS****/

}