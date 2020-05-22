Mat im1 = imread("JuVIA.png", CV_LOAD_IMAGE_COLOR);

    vector<Rect> faces;
    CascadeClassifier cascade( "C:/local/opencv249/sources/data/haarcascades/haarcascade_frontalface_alt2.xml" );
    cascade.detectMultiScale( im1, faces, 1.1, 2, 0| CV_HAAR_SCALE_IMAGE, Size(30, 30) );

    for( vector<Rect>::const_iterator r = faces.begin(); r != faces.end(); r++ )
        cv::rectangle( im1, *r, CV_RGB(255,0,0) );

    imshow("in", im1);
    imwrite( "miss4.png", im1);
    waitKey();