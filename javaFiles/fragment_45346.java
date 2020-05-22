public static void main(String[] args) {
    boolean mouseOver;
    int width = 50;
    int height = 50;
    double x = 40;
    double y = 40;
    double mx = 40;
    double my = 40;
    if ((mx <= x + ((double) width / 2)) && (mx >= x  - ((double) width / 2))
            && (my >= y  - ((double) height / 2)) 
            && (my <= y  + ((double) height / 2))) { 
        mouseOver = true;
    } else {
        mouseOver = false;
    }
    System.out.println(mouseOver);
}