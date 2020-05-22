First thing you shouldn't call getFromLocation from main thread as this method is synchronous and may take a long time to do its work, so you should not call it from the main, user interface (UI) thread of your app. you should use Intent service class.
Here is code for it:


public class GetAddressService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    protected ResultReceiver mReceiver;
    //protected DataEntry.AddressResultReceiver mReceiver;
    private static final String TAG = "GetAddressService";

    public GetAddressService() {
        super("GetAddressService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        mReceiver = intent.getParcelableExtra(Constants.RECEIVER);
        Log.e(TAG,"mReceiver"+mReceiver);
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = null;
                String errorMessage = "";
                // Get the location passed to this service through an extra.
                Location mCurrentLocation = intent.getParcelableExtra(Constants.LOCATION_DATA_EXTRA);
                try {
                    addresses = geocoder.getFromLocation(mCurrentLocation.getLatitude(),
                            mCurrentLocation.getLongitude(), 1);

                } catch (IOException e) {
                    errorMessage = "Service error: ";
                    Log.e(TAG, errorMessage, e);
                } catch (IllegalArgumentException illegalArgumentException) {
                    // Catch invalid latitude or longitude values.
                    errorMessage = "invalid_lat_long_used";
                    Log.e(TAG, errorMessage + ". " +
                            "Latitude = " + mCurrentLocation.getLatitude() +
                            ", Longitude = " +
                            mCurrentLocation.getLongitude(), illegalArgumentException);
                }
                // Handle case where no address was found.
                if (addresses == null || addresses.size() == 0) {
                    if (errorMessage.isEmpty()) {
                        errorMessage = "no_address_found";
                        Log.e(TAG, errorMessage);
                    }
                    deliverResultToReceiver(Constants.FAILURE_RESULT,errorMessage);
                }else {
                    String cityName = addresses.get(0).getLocality();
                    String countryName = addresses.get(0).getCountryName();
                    String rLocation = cityName + "," + countryName;
                    Log.e(TAG, "location: " + rLocation);
                    deliverResultToReceiver(Constants.SUCCESS_RESULT,rLocation);
                }
    }

//To deliver the result back to the activity which started the service

    private void deliverResultToReceiver(int resultCode, String message) {
        //mReceiver = new ResultReceiver(this);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.RESULT_DATA_KEY, message);
        mReceiver.send(resultCode, bundle);
        Log.e(TAG,"Delivering result"+message);
    }


}


//Constant class to store all constants in one place

public final class Constants {
    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;
    public static final String PACKAGE_NAME =
            "your package name";
    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME +
            ".RESULT_DATA_KEY";
    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME +
            ".LOCATION_DATA_EXTRA";

}


//call this GetAddressService from your activity

private AddressResultReceiver mResultReceiver;

private class MyLocationListener implements LocationListener{
        @Override
        public void onLocationChanged(Location loc){
        Intent intent = new Intent(this,GetAddressService.class);
        intent.putExtra(Constants.RECEIVER,mResultReceiver);
        intent.putExtra(Constants.LOCATION_DATA_EXTRA,loc);
        startService(intent);
        }



//class to receive the address back from the service
 class AddressResultReceiver extends ResultReceiver{

        /**
         * Create a new ResultReceive to receive results.  Your
         * {@link #onReceiveResult} method will be called from the thread running
         * <var>handler</var> if given, or from an arbitrary thread if null.
         *
         * @param handler
         */
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            mAddressOutput = resultData.getString(Constants.RESULT_DATA_KEY);
            Log.e(TAG,"Address is:"+mAddressOutput);
        }
    }