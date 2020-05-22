//sort by y coordinates using the topleft point of every contour's bounding box
Collections.sort(contourList, new Comparator<MatOfPoint>() {
    @Override
    public int compare(MatOfPoint o1, MatOfPoint o2) {
        Rect rect1 = Imgproc.boundingRect(o1);
        Rect rect2 = Imgproc.boundingRect(o2);
        int result = Double.compare(rect1.tl().y, rect2.tl().y);
        return result;
    }
} );


 //sort by x coordinates
 Collections.sort(contourList, new Comparator<MatOfPoint>() {
    @Override
    public int compare(MatOfPoint o1, MatOfPoint o2) {
        Rect rect1 = Imgproc.boundingRect(o1);
        Rect rect2 = Imgproc.boundingRect(o2);
        int result = 0;
        double total = rect1.tl().y/rect2.tl().y;
        if (total>=0.9 && total<=1.4 ){
            result = Double.compare(rect1.tl().x, rect2.tl().x);
        }
        return result;
    }
});