Mat raw=new Mat();
Mat hsv=new Mat();
org.opencv.android.Utils.bitmapToMat(changedBitmap, raw);
Imgproc.cvtColor(raw, hsv, Imgproc.COLOR_RGB2HSV);
Imgproc.cvtColor(raw, raw, Imgproc.COLOR_RGB2GRAY);
double maxH = 0;
Mat thresh = new Mat();
Core.inRange(hsv, new Scalar(H_MIN, S_MIN, V_MIN), new Scalar(H_MAX, S_MAX, V_MAX), thresh);