public Triangle(Triangle other) {
    super(clonePoints(other));
}

private static Point[] clonePoints(Triangle other) {
     if (other == null) {
         // ...
     }

     return other.getPoints().clone();
}