public double[] linearInterp(double[] x, double[] y, double[] xi) {
   LinearInterpolator li = new LinearInterpolator(); // or other interpolator
   PolynomialSplineFunction psf = li.interpolate(x, y);

   double[] yi = new double[xi.length];
   for (int i = 0; i < xi.length; i++) {
       yi[i] = psf.value(xi[i]);
   }
   return yi;
}