if (mLastLocation == null || !Geocoder.isPresent()) {
    Toast.makeText(this, R.string.no_geocoder_available, Toast.LENGTH_LONG).show();
    return;
}

latitude = String.valueOf(mLastLocation.getLatitude());
longitude = String.valueOf(mLastLocation.getLongitude());