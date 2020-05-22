protected Point2D getPointOnCircle(Point2D center, double radians, double radius) {

    double x = center.getX();
    double y = center.getY();

    radians = radians - Math.toRadians(90.0); // 0 becomes the top
    // Calculate the outter point of the line
    double xPosy = Math.round((float) (x + Math.cos(radians) * radius));
    double yPosy = Math.round((float) (y + Math.sin(radians) * radius));

    return new Point2D.Double(xPosy, yPosy);

}