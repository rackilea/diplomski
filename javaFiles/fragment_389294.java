Point[] points = new Point[]{ new Point(), new Point() };
for (int x = 0; x < matLines.cols(); x++) {
   double[] vec = matLines.get(0, x);
   points[0].x = vec[0];
   points[0].y = vec[1];
   points[1].x = vec[2];
   points[1].y = vec[3];
   //...
}