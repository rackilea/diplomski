public void method1(LinkedList<Point> xList, LinkedList<Point> yList) {
    xList.add(new Point(10, 10));
    yList.add(new Point(20, 10));
}

public void method2() {

    LinkedList<Point> xPoints = new LinkedList<Point>();
    LinkedList<Point> yPoints = new LinkedList<Point>();

    xPoints.add(new Point(20, 40));
    yPoints.add(new Point(15, 15));

    class1 get = new class1();
    get.method1(xPoints, yPoints);
    // use xPoints and yPoints here: new point is already added
}