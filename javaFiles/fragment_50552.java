Mat frame = Highgui.imread("image/test.jpg");
// this is not a copy of frame, drawings on frameROI will also appear on frame
// rect describes ROI, starting at x,y = 50 and width, height = 100 
Mat frameROI = new Mat(frame, new Rect(50, 50, 100, 100));

// find contours in (processed to improve contour finding) frameROI
Imgproc.findContours(frameROIprepared, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

// go through all the contours in my contour list and draw them
for (int i = 0; i < contours.size(); i++)
    Imgproc.drawContours(frameROI, contours, i, new Scalar(0, 255, 0));