RotatedRect rect = null;

Mat points = Mat.zeros(bin.size(),bin.type());
Core.findNonZero(bin, points);

MatOfPoint mpoints = new MatOfPoint(points);
MatOfPoint2f points2f = new MatOfPoint2f(mpoints.toArray());

if (points2f.rows() > 0) {
    rect = Imgproc.minAreaRect(points2f);
}