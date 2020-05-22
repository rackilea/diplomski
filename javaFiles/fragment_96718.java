public void calculateCordinates(int degrees, int r){
    degrees = degrees+90;
    while(degrees>=360){degrees=degrees-360;}//ensures that degree < 360°
    double x;
    double y;
    x = Math.acos(Math.toRadians((double)degrees))*r;
    y = x/Math.atan(Math.toRadians((double)degrees));
}