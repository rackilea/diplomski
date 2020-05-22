Bitmap bm = someImage;
int startx, starty;
int degree = rotateDegree % 360; // counterclockwise
if (degree >= 0 && degree < 90) {
    startx = bm.getWidth();
    starty = 0;
} else if (degree >= 90 && degree < 180) {
    startx = bm.getWidth();
    starty = bm.getWidth();
} else if (degree >= 180 && degree < 270) {
    startx = 0();
    starty = bm.getWidth();
} else {
    startx = 0;
    starty = 0;
}