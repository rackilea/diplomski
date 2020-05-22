IplImage img=cvLoadImage("pathtosourceimage");
    CvSize cvSize = cvSize(img.width(), img.height());
    IplImage gry=cvCreateImage(cvSize, img.depth(), 1);
    cvCvtColor(img, gry, CV_BGR2GRAY);
    cvThreshold(gry, gry, 200, 255, CV_THRESH_BINARY);
    cvAdaptiveThreshold(gry, gry, 255, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY_INV, 11, 5);

    CvMemStorage storage = CvMemStorage.create();
    CvSeq contours = new CvContour(null);

    int noOfContors = cvFindContours(gry, storage, contours, Loader.sizeof(CvContour.class), CV_RETR_CCOMP, CV_CHAIN_APPROX_NONE, new CvPoint(0,0));

    CvSeq ptr = new CvSeq();

    int count =1;
    CvPoint p1 = new CvPoint(0,0),p2 = new CvPoint(0,0);

    for (ptr = contours; ptr != null; ptr = ptr.h_next()) {

        CvScalar color = CvScalar.BLUE;
        CvRect sq = cvBoundingRect(ptr, 0);

            System.out.println("Contour No ="+count);
            System.out.println("X ="+ sq.x()+" Y="+ sq.y());
            System.out.println("Height ="+sq.height()+" Width ="+sq.width());
            System.out.println("");

            p1.x(sq.x());
            p2.x(sq.x()+sq.width());
            p1.y(sq.y());
            p2.y(sq.y()+sq.height());
            cvRectangle(img, p1,p2, CV_RGB(255, 0, 0), 2, 8, 0);
            cvDrawContours(img, ptr, color, CV_RGB(0,0,0), -1, CV_FILLED, 8, cvPoint(0,0));
            count++;

    }

    cvShowImage("contures",img);
    cvWaitKey(0);