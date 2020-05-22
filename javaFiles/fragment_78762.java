String inchesToDp(int x, int y){

    DisplayMetrics metrics = getResources().getDisplayMetrics();
    //int densityDpi = metrics.densityDpi;  used for general purpose
    int xInch = x * metrics.xdpi;     //1 inch in dpi is just the amount of dpi
    int yInch = y * metrics.ydpi;     //x and ydpi give exact lcd dpi for horizontal and vertical but you could just use x * densityDpi if it doesn't matter

    return "x in dp: " + xInch + "y in dp: " + yInch;

}