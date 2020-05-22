public void getAddressFromLocation(final double latitude, final double longitude,
                                          final Context context, final Handler handler)
{
    Thread thread = new Thread()
    {
        @Override
        public void run()
        {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            String result = null;
            Address address = null;

            try
            {
                List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);

                if (addressList != null && addressList.size() > 0)
                {
                    address = addressList.get(0);
                }
            }
            catch (Exception e)
            {
                Log.e(TAG, "getAddressFromLocation:run: exception while getting address from location");
                e.printStackTrace();
            }
            finally
            {
                Message message = Message.obtain();
                message.setTarget(handler);

                if (address != null)
                {
                    message.what = 1;
                    Bundle bundle = new Bundle();

                    bundle.putString("thoroughFare", address.getThoroughfare());
                    bundle.putString("subThoroughFare", address.getSubThoroughfare());
                    bundle.putString("city", address.getLocality());
                    bundle.putString("state", address.getAdminArea());
                    bundle.putString("country", address.getCountryName());
                    bundle.putString("postalCode", address.getPostalCode());
                    bundle.putString("subAdminArea", address.getSubAdminArea());
                    bundle.putString("subLocality", address.getSubLocality());
                    message.setData(bundle);
                }
                else
                {
                    message.what = 1;
                    Bundle bundle = new Bundle();

                    result = "Latitude: " + latitude + "Longitude: " + longitude +
                            "\n Unable to get address for this location.";

                    bundle.putString("address", result);
                    message.setData(bundle);
                }

                message.sendToTarget();
            }
        }
    };

    thread.start();
}