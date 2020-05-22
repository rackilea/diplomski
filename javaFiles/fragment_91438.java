Mat tmp = new Mat (b.getWidth(), b.getHeight(), CvType.CV_8UC1);
Utils.bitmapToMat(b, tmp);
Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_RGB2GRAY);
//there could be some processing
Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_GRAY2RGB, 4);
Utils.matToBitmap(tmp, b);