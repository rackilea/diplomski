public class LocationManager implements AMapLocationListener {
    public interface OnLocationCallback{
        public void onLocateSuccess(double lng, double lat, String addr);
        public void onLocateFail(int code, String info);
    }
    private static volatile LocationManager mInstance = null;
    private Context context;
    public AMapLocationClient mLocationClient = null;
    private OnLocationCallback mCallback;

    private LocationManager(Context context){
        this.context = context;
        init(this.context);
    }

    public static LocationManager getInstance(Context context){
        if(mInstance == null){
            synchronized (LocationManager.class){
                if(mInstance == null){
                    mInstance = new LocationManager(context);
                }
            }
        }
        return mInstance;
    }

    private void init(Context context){
        mLocationClient = new AMapLocationClient(context);
        mLocationClient.setLocationListener(this);
        initLocationParams();

    }
    private void initLocationParams(){
        AMapLocationClientOption mLocationOption = null;
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setWifiActiveScan(true);
        mLocationOption.setMockEnable(false);
        mLocationOption.setInterval(2000);
        mLocationClient.setLocationOption(mLocationOption);
    }

    public void startLocation(OnLocationCallback callback){
        this.mCallback = callback;
        mLocationClient.startLocation();
    }
    public void stopLocation(){
        this.mCallback = null;
        mLocationClient.stopLocation();
    }


    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                amapLocation.getLocationType();
                amapLocation.getLatitude();
                amapLocation.getLongitude();
                amapLocation.getAccuracy();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);
                amapLocation.getAddress();
                amapLocation.getCountry();
                amapLocation.getProvince();
                amapLocation.getCity();
                amapLocation.getDistrict();
                amapLocation.getRoad();
                amapLocation.getCityCode();
                amapLocation.getAdCode();

                if(mCallback != null){
                    mCallback.onLocateSuccess(amapLocation.getLongitude(), amapLocation.getLatitude(), amapLocation.getAddress());
                }
            } else {

                Log.e("AmapError", "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
                if(mCallback != null){
                    mCallback.onLocateFail(amapLocation.getErrorCode(), amapLocation.getErrorInfo());
                }
            }
        }
    }
}