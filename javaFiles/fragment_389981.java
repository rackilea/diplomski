IplImage gray = cvCreateImage( cvSize( img.width, img.height ), IPL_DEPTH_8U, 1 );
cvCvtColor( img, gray, CV_RGB2GRAY );
// smooth it, otherwise a lot of false circles may be detected
cvSmooth(gray,gray,CV_GAUSSIAN,9,9,2,2);
CvMemStorage circles = CvMemStorage.create();
CvSeq seq = cvHoughCircles(gray, circles.getPointer(), CV_HOUGH_GRADIENT,
                                                2, img.height/4, 100, 100, 0, 0);
for(int i=0; i<seq.total; i++){
        float xyr[] = cvGetSeqElem(seq,i).getFloatArray(0, 3);
        CvPoint center = new CvPoint(Math.round(xyr[0]), Math.round(xyr[1]));

        int radius = Math.round(xyr[2]);
        cvCircle(img, center.byValue(), 3, CvScalar.GREEN, -1, 8, 0);
        cvCircle(img, center.byValue(), radius, CvScalar.BLUE, 3, 8, 0);
}