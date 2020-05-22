private Box expandedBox(Point northeastPoint, Point southwestPoint){

    // percentage of distance to set as padding to the box
    Double offset = 0.1;
    Double distance = pointDistance(northeastPoint, southwestPoint);
    Double padding = (distance * offset);

    // get current x, y
    Double neX = northeastPoint.getX();
    Double neY = northeastPoint.getY();
    Double swX = southwestPoint.getX();
    Double swY = southwestPoint.getY();

    // init new x, y
    Double neX2, neY2, swX2, swY2;


    if(neX > swX){
        neX2 = neX + padding;
        swX2 = swX - padding;
    } else {
        neX2 = neX - padding;
        swX2 = swX + padding;
    }

    if(neY > swY){
        neY2 = neY + padding;
        swY2 = swY - padding;
    } else {
        neY2 = neY - padding;
        swY2 = swY + padding;
    }

    northeastPoint = new Point(neX2, neY2);
    southwestPoint = new Point(swX2, swY2);

    return new Box(northeastPoint, southwestPoint);
}

private Double pointDistance(Point p1, Point p2) {
    return Math.sqrt((p2.getY() - p1.getY()) * (p2.getY() - p1.getY()) + (p2.getX() - p1.getX()) * (p2.getX() - p1.getX()));
}