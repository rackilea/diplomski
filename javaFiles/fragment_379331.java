public static Shape shapeWithLargestArea(ArrayList<Shape> shapes) {
    Shape largestShape = null;
    for(Shape shape: shapes) {
        if(largestShape == null || shape.area() > largestShape.area())
            largestShape = shape;
    } 
    return largestShape;
}