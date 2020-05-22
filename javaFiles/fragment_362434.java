public void codeQR(final Context context, final Activity activity){

    client2 = LocationServices.getFusedLocationProviderClient(context);
    client2.getLastLocation().addOnSuccessListener(activity, new OnSuccessListener<Location>() {
        @Override
        public void onSuccess(Location location) {

            latitude = location.getLatitude();
            longitude = location.getLongitude();
            result = (latitude +longitude);

            anotherMethod(result);
        }
    });
}