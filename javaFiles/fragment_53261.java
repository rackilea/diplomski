double[] x = {86.92, 70.93, 97.74, 30.90, 51.66, 0.83, 55.91, 32.92, 65.26, 83.90};
double[] y = {2.47, 27.81, 34.36, 35.14, 31.70, 21.77, 66.62, 75.23, 72.53, 4.710};
Cartesian[] pointC = new Cartesian[Math.min(x.length, y.length)];
double[] distance  = new double[pointC.length - 1];
for(int i = 0; i < pointC.length; i++){
    pointC[i] = new Cartesian(x[i], y[i]);
}
for(int i = 0; i < distance.length; i++){
    distance[i] = Cartesian.distance(pointC[i], pointC[i+1]);
}