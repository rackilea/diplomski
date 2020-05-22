int getArea(double xcoord, double ycoord , double radius) {
    if(xcoord*xcoord + ycoord*ycoord > radius*radius)
        return -1;
    double angle = Math.PI/2 - Math.atan2(ycoord, xcoord); // Need to suptract the angle from Pi/2 because we want 0 rad to be at +y axis instead of +x axis
    if(angle < 0) // Math.atan2 gives angle in range -Pi/2 to Pi/2 so need to shift it to range 0 to 2*Pi
        angle = 2*Math.PI + angle;
    int segments = 12;
    double angle_one_segment = 2*Math.PI/segments;
    return 1 + (int)(angle/angle_one_segment); // From 12 o'clock to 1 o'clock it's first sector (exactly 12 belongs to 1st sector) and so on. If point (x, y) lies exactly at the boundary between 2 sectors it belongs to the higher one
}