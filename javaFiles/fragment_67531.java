try {

                    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

                } catch (SecurityException se) {
                    Toast.makeText(this, "Please provide location permissions to continue", Toast.LENGTH_SHORT).show();
                }