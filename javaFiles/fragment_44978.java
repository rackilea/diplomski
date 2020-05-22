public class Earthquakes {
    private String mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public Earthquakes(String magnitude, String location, Long timeInMilliseconds){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getTimeInMilliseconds() {return mTimeInMilliseconds;}
    }