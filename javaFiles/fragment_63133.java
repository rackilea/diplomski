private static class StopItem implements Comparable<StopItem> {
    double stopLat, stopLon, stopDist;

    public StopItem( double stopLat, stopLon, stopDist ) {
        this.stopLat = stopLat;
        this.stopLon = stopLon;
        this.stopDist = stopDist;
    }

    // Getters, setters...

    @Override
    public int compareTo( StopItem otherItem ) {
        return Double.compare( this.stopDist, otherItem.stopDist );
    }

}