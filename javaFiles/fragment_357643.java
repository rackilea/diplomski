private double windowToRatio(double window) {
    Rectangle2D scaledDataArea = getScreenDataArea();
    return (window - scaledDataArea.getMinX()) / scaledDataArea.getWidth();
}

private double ratioToModel(double ratio) {
    Range domainRange = getChart().getXYPlot().getDomainAxis().getRange();
    return domainRange.getLowerBound() + ratio * domainRange.getLength();
}