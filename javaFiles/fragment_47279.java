public void createCircles(int x, int y, int rad) {

    Circle myCircle = new Circle(x, y, rad);
    circles.add(myCircle);

    createCircles(x - (2*rad), y, rad/3);
    createCircles(x, y, rad/3);
    createCircles(x + (2*rad), y, rad/3);
}