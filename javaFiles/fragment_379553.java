IplImage img = cvLoadImage("image.jpg");
CvRect foundRects = new CvRect(null);
HOGDescriptor hog = new HOGDescriptor(); 
FloatPointer svm = HOGDescriptor.getDefaultPeopleDetector();
hog.setSVMDetector(svm);
hog.detectMultiScale(img, foundRects, 0, cvSize(8,8), cvSize(32,32), 1.05, 2);