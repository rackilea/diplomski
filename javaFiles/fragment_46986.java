IplImage imageSrc = cvLoadImage("pipeline.png", CV_LOAD_IMAGE_COLOR);
    if (imageSrc == null) 
    {
        System.out.println("!!! Failed loading image");
        return;
    }

    double r, g, b;
    r = g = b = 0.0;               

    IplImage imageDst = IplImage.create(imageSrc.width(), imageSrc.height(), IPL_DEPTH_8U, 3);

    CvMat imagePixels = CvMat.createHeader(imageDst.height(), imageDst.width(), CV_32FC1);  
    cvGetMat(imageDst, imagePixels, null, 0); 
    int x, y;
    for(y=0; y<imageSrc.height(); y++)
       for(x=0; x<imageSrc.width(); x++)
       {
            CvScalar rgb = cvGet2D(imagePixels, y, x);
            r = rgb.val(0);
            g = rgb.val(2);
            b = rgb.val(1);

            double gray = (r + g + b) / 3;

            CvScalar scalar = new CvScalar();
            scalar.setVal(0, gray);
            scalar.setVal(1, gray);
            scalar.setVal(2, gray);
           cvSet2D(imagePixels, y, x, scalar);
       }
       imageDst = new IplImage(imagePixels);  

       IplImage result = new IplImage(imagePixels); 
       cvSaveImage("manual_gray.png", result);

       cvReleaseImage(imageSrc);