public static Rectangle placeAbove(JComponent j, int a) {
    int x= j.getX();
    int y= j.getY();
    int w= j.getWidth();
    int h= j.getHeight();

    y=(y-h)-a;

    //return our new bounds projected in a Rectangle Object
    return new Rectangle(x, y, w, h); 
}