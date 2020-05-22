public IplImage openImage(String name) {

    IplImage img = cvLoadImage(name);
    if(img != null)
    {
        cvShowImage("hello", img);
        cvWaitKey();
        cvReleaseImage(img);
    }
    return img;
}