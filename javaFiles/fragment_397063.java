private static Mat floodFill(Mat img)
{
    Mat floodfilled = Mat.zeros(img.rows() + 2, img.cols() + 2, CvType.CV_8U);
    Imgproc.floodFill(img, floodfilled, new Point(0, 0), new Scalar(255), new OpenCVForUnity.Rect(), new Scalar(0), new Scalar(0), 4 + (255 << 8) + Imgproc.FLOODFILL_MASK_ONLY);

    Core.subtract(floodfilled, Scalar.all(0), floodfilled);

    Rect roi = new Rect(1, 1, img.cols() - 2, img.rows() - 2);
    Mat temp = new Mat();

    floodfilled.submat(roi).copyTo(temp);

    img = temp;

    //Core.bitwise_not(img, img);

    return img;
}