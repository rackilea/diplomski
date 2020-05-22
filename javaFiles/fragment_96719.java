public void calculateCordinates(int degrees, int degrees3D, int r){
    degrees = degrees+90;
    while(degrees>=360){degrees=degrees-360;}
    double x;
    double y;
    double z;
    x = Math.acos(Math.toRadians((double)degrees))*r;
    y = x/Math.atan(Math.toRadians((double)degrees));
    z = x/Math.atan(Math.toRadians((double)degrees3D));
}