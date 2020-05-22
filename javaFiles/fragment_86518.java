Point[] points;

public MethodAccess()//constructor
{
    points = new Point[]{new Point(1,1), new Point(2,2)};
    Polygon p = polygonFrom(points);
}

public Polygon polygonFrom(Point[] corners){

    //doing stuff with corners variable here

    points = corners; //this will change the points variable that was passed

}