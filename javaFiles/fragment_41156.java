CvSeq faces = cvHaarDetectObjects(grayImage, classifier, storage,
                1.1, 3, CV_HAAR_DO_CANNY_PRUNING);

for (int i = 0; i < faces.total(); i++) {
   // its ok
}