public static void drawCircle(int radio, double xCenter, double yCenter) {
    double t = 0;
    double xPoint;
    double yPoint;
    double xActual = xCenter;
    double yActual = yCenter + radio*sin(0);
    t += 0.01;
    while(t < 360) {
        xPoint = xCenter + radio*cos(t);
        yPoint = yCenter + radio*sin(t);
        //you should write this function based on
        //the platform you're working (Swing, AWT...)
        drawLine(xActual, yActual, xPoint, yPoint);
        t += 0.01;
        xActual = xPoint;
        yActual = yPoint;
    }
}