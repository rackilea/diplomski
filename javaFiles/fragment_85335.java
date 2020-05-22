class DistanceInfo implements Comparable<DistanceInfo> {
    public double a;
    public double b;
    public double distance;
    public DistanceInfo (double a, double b, double distance) {
        this.a = a; 
        this.b = b;
        this.distance = distance;
    }
    @Override public int compareTo (DistanceInfo d) { 
        return Double.compare(distance, d.distance);
    }
}

// then:
DistanceInfo[] distancearray = new DistanceInfo[array.length];

// and you can load it using the constructor:
for (int i = 0; i < array.length) {
    double a = Double.parseDouble(array[i][0]);
    double b = Double.parseDouble(array[i][1]);
    distancearray[i] = new DistanceInfo(a, b, Distance);
}