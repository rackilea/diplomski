public static double eval0(double[] X, double[] Y) {
  double sum = 0.0;
  assert(X.length == Y.length);
  int iters = X.length/3;
  for (int i = 0; i < iters; i++) {
    int at = 3*i;
    double x0 = X[at + 0];
    double x1 = X[at + 1];
    double x2 = X[at + 2];
    double y0 = Y[at + 0];
    double y1 = Y[at + 1];
    double y2 = Y[at + 2];
          double x1y2 = x1*y2;
          double x2y1 = x2*y1;
          double a = x1y2-x2y1;
          double x2y0 = x2*y0;
          double x0y2 = x0*y2;
          double b = x2y0-x0y2;
          double x0y1 = x0*y1;
          double x1y0 = x1*y0;
          double c = x0y1-x1y0;
    sum += a + b + c;
  }
return sum;