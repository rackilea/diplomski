public boolean servicesOK() {

        int isAvailable = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);

        if (isAvailable == ConnectionResult.SUCCESS) {

            return true;

        } else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable,
                    this, GPS_ERRORDIALOG_REQUEST);
            dialog.show();

        } else {

            Toast.makeText(this, "Cant connect!!", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
}