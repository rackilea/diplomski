@Override
protected void layoutPlotChildren() {
    double x = ... ; // x coordinate of image in xAxis coordinates
    double y = ... ; // y coordinate of image in yAxis coordinates

    double layoutX = getXAxis().getDisplayPosition(x);
    double layoutY = getYAxis().getDisplayPosition(y);

    iv1.setLayoutX(layoutX);
    iv1.setLayoutY(layoutY);

    super.layoutPlotChildren();
}