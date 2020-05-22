for (int i = 0; i < stations.size(); i++) {

    double scalingFactorx = width/(maxLat - minLat);
    double scalingFactory = height/(maxLong - minLong);
    double scalingFactor = Math.min(scalingFactorx, scalingFactory);

    double drawingX = (stations.get(i).getLatitude() - minLat)/(maxLat-minLat);
    double drawingY = (stations.get(i).getLongitude() - minLong)/(maxLong-minLong);
    //double drawingY2 = height - drawingY; This line isn't needed. It causes the text to be drawn outside the jpanel.
    gr.drawString(stations.get(i).getName(), (int)drawingX, (int)drawingY);

}