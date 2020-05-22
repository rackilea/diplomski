Polygon p; //your polygon
int x_mouse;//your mouse click pos
int y_mouse;
for (int i = 0; i < p.npoints; i ++){
    int x_from = 0;
    int y_from = 0;         
    int x_to = 0;
    int y_to = 0;

    if (i == 0){ //i-1 == -1 -> p.npoints-1
        x_from = p.xpoints[p.npoints-1];
        y_from = p.ypoints[p.npoints-1];
    }else{
        x_from = p.xpoints[i-1];
        y_from = p.ypoints[i-1];
    }       
    x_to = p.xpoints[i];
    y_to = p.ypoints[i];


    Line2D line = new Line2D.Double(x_from, y_from, x_to, y_to);
    if (line.ptLineDist(new Point(x_mouse, y_mouse)) <= 0.01){
        //you hit
    }

}