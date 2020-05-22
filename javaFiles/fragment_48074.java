for (int i=0; i < nPoints; i++) {
   double x = Math.cos(i * ((2 * Math.PI) / nPoints)) * radius[i % 4];
   double y = Math.sin(i * ((2 * Math.PI) / nPoints)) * radius[i % 4];

   X[i] = (int) x + midX;
   Y[i] = (int) y + midY;
}