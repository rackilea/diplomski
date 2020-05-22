if(rgbMat == null){
    rgbMat = inputFrame.rgba();
    bgrPixel= rgbMat.submat(1,1,2,2).clone();
    grayPixel = new Mat();
    Imgproc.cvtColor(bgrPixel, grayPixel, Imgproc.COLOR_BGR2GRAY,1);
}