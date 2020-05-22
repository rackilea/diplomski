private static final float GAP_LAT_LON = 0.00005f; //aprox 5 meters
private float results[] = new float[1];

private PointF getGaps(Location initial, float distanceX, float distanceY, PointF gaps){
    Location.distanceBetween(initial.getLatitude(), initial.getLongitude(), initial.getLatitude(), initial.getLongitude() + GAP_LAT_LON, results);
    double factorX = GAP_LAT_LON / results[0];
    Location.distanceBetween(initial.getLatitude(), initial.getLongitude(), initial.getLatitude() + GAP_LAT_LON, initial.getLongitude(), results);
    double factorY = GAP_LAT_LON / results[0];
    if(gaps == null)
        gaps = new PointF();
    gaps.set((float)(distanceX * factorX), (float)(distanceY * factorY));
    return gaps;
}

//to use
private void teste(){
    PointF gaps = null;
    Location initial = new Location("");

    initial.setLatitude(23.5);
    initial.setLongitude(13.2);

    //100 meters West/East and 300 meters North/South
    getGaps(initial, 100, 300, gaps);

    //gaps.x returns x offset to add/subtract to initial latitude
    //gaps.y returns y offset to add/subtract to initial longitude
}