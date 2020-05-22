public class CycleTrails {
    static double LAT_MAX = myLatitude + (0.0144927 * 20);
    static double LAT_MIN = myLatitude - (0.0144927 * 20);
    static double LON_MAX = myLongitude + (0.0181818 * 20);
    static double LON_MIN = myLongitude - (0.0181818 * 20);

    public static ArrayList<Trails> getTrails() {
        ArrayList<Trails> trailList = new ArrayList<>();
        Trails t1 = new Trails(51.7181283, -3.3633637, "Bike Park Wales");
        Trails t2 = new Trails(51.6666343, -3.3526367, "Mountain Ash");
        Trails t3 = new Trails(50.5062244,-4.1777985, "FlyUp Downhill");
        trailList.add(t1);
        trailList.add(t2);
        trailList.add(t3);

        ArrayList<Trails> localTrails = new ArrayList<>();
        for(Trails trail : trailList) {
            if (trail.lat > LAT_MIN && trail.lat < LAT_MAX && trail.lon < LON_MIN && trail.lon > LON_MAX) {
               localTrails.add(trail);
               Log.d("Calc", "Run code");
            }
        }
       return localTrails;
    }

}