//A) Create a callback Interface
 public interface MyCallback {
    void onCallback(Double result);
}

//B) Put this callback in your method parameter
public void codeQR(final Context context, final Activity activity, MyCallback myCallback){

    client2 = LocationServices.getFusedLocationProviderClient(context);
    client2.getLastLocation().addOnSuccessListener(activity, new OnSuccessListener<Location>() {
        @Override
        public void onSuccess(Location location) {

            latitude = location.getLatitude();
            longitude = location.getLongitude();
            result = (latitude +longitude);

            myCallback.onCallback(result);
            }
        });
    }

    //C) Call your method wherever you need to access the "result" value
    //For example, if you want to get the result value in the nextStep() method
    private void nextStep(){
       codeQR(this, this, new MyCallback() {
          @Override
          public void onCallback(Double result) {
                    Log.i("TestOfResult", "onCallback: " + result);
                }
          });
     }