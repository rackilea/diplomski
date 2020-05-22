public class TrackableAsyncTask extends AsyncTask<String, String, String>{
    public abstract int getId();

    public static final int ID_AIRPORT = 1;
    public static final int ID_BEACONS = 2;
    ... etc
}