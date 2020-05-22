// create ROI
OpenCV.Core.Rect ROI = new OpenCV.Core.Rect(leftX, leftTopY, 600, 200);
// deep copy ROI to new image
Mat croppedImage = (new Mat(digitsMask, ROI)).clone();
// create bitmap
Bitmap bmp = null;
// create a new 4 channel Mat because bitmap is ARGB
Mat tmp = new Mat (croppedImage.rows(), croppedImage.cols(), CvType.CV_8U, new Scalar(4));
// convert ROI image from single channel to 4 channel
Imgproc.cvtColor(croppedImage, tmp, Imgproc.COLOR_GRAY2RGBA, 4);
// Initialize bitmap
bmp = Bitmap.createBitmap(croppedImage.cols(), croppedImage.rows(), Bitmap.Config.ARGB_8888);
// convert Mat to bitmap
Utils.matToBitmap(tmp, bmp);