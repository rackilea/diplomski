private PointF mapBeginCoordinates(PointF beginCoordinate, PointF endCoordinate) {
    //TODO we only have one aspect ratio for the current picture, so we should remove redundancy
    float left = Math.min(beginCoordinate.x, endCoordinate.x);
    float top = Math.min(beginCoordinate.y, endCoordinate.y);
    double wAr = UtilFunctions.getAspectRatio(originalWidth, layers[0].getIntrinsicWidth());
    double hAr = UtilFunctions.getAspectRatio(originalHeight, layers[0].getIntrinsicHeight());
    if(!isZoomed()) {
        left = (float) (left / wAr);
        top = (float) (top / hAr);
    }
    if(isZoomed()) {
        PointF b = transformCoordTouchToBitmap(left,top,true);
        left = (float) (b.x / wAr);
        top = (float) (b.y / hAr);
    }
    return new PointF(left,top);
}