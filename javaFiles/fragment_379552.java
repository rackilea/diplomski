// javacv/cpp/opencv_objdetect.java:527
public static class HOGDescriptor extends Pointer {
    public HOGDescriptor();
    ...
    public native void setSVMDetector(CvArr _svmdetector);
    ...
    public native void compute(CvArr img, FloatPointer descriptors, CvSize winStride, CvSize padding, CvPoint locations);
    public native void detect(CvArr img, CvPoint foundLocations, DoublePointer weights, double hitThreshold, CvSize winStride, CvSize padding, CvPoint searchLocations);
    public native void detect(CvArr img, CvPoint foundLocations, double hitThreshold, CvSize winStride, CvSize padding, CvPoint searchLocations);
    public native void detectMultiScale(CvArr img, CvRect foundLocations, double hitThreshold, CvSize winStride, CvSize padding, double scale, int groupThreshold);
    public native void detectMultiScale(CvArr img, CvRect foundLocations, DoublePointer foundWeights, double hitThreshold, CvSize winStride, CvSize padding, double scale, double finalThreshold, boolean useMeanshiftGrouping);
    public native void detectMultiScale(CvArr img, CvRect foundLocations, double hitThreshold, CvSize winStride, CvSize padding, double scale, double finalThreshold, boolean useMeanshiftGrouping);
    ...
};