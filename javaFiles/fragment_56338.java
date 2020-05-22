double x = originx;
double y = originy + value[0]*scale;
for(int angle=1 ; angle< 360; angle++){
    double rad = angle*Math.PI/180.0;
    double x1 = originx + value[i]*scale*Math.cos(rad);
    double y1 = originy + value[i]*scale*Math.sin(rad);
    graphics.drawLine(int)x, (int)y, (int)x1, (int)y1);
    x = x1;
    y = y1;
}