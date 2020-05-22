protected String test = "foo";

public void myRepaint(long tm, int x, int y, int width, int height, test) {
    this.test = test;
    repaint(tm, x, y, width, height);
}

public void paint(Graphics g) {
    //do something with this.test
}