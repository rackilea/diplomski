public double getDistance(double[] points1, double[] points2){
    double x1 = points1[0];
    double x2 = points2[0];
    double y1 = points1[1];
    double y2 = points2[1];
    double z1 = points1[2];
    double z2 = points2[2];

    double distance = Math.sqrt(Math.pow(x1 - x2, 2) +(Math.pow(y1 - y2, 2) + 
                        (Math.pow(z1 - z2, 2))));
    return distance;
}