public static float matchScore(Mat src,Mat tmp){

    Size size = new Size(src.cols()-tmp.cols()+1, src.rows()-tmp.rows()+1);
    Mat result = new Mat(size, CV_32FC1);
    matchTemplate(src, tmp, result, TM_CCORR_NORMED);
    DoublePointer minVal= new DoublePointer();
    DoublePointer maxVal= new DoublePointer();
    Point min = new Point();
    Point max = new Point();
    FloatIndexer fi = result.createIndexer();
    minMaxLoc(result, minVal, maxVal, min, max, null);      
    return fi.get(max.y(),max.x());
}