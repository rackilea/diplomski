public void mousePressed(int button, int x, int y) {
    pressedX = x;
    pressedY = y;
    num++;
    point[num] = new Point(pressedX, pressedY);
}