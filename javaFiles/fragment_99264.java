private boolean requestLocationPermission() {

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return true;
    }
    if (checkSelfPermission(mContext, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        return true;
    }

    if (shouldShowRequestPermissionRationale((Activity)mContext, ACCESS_FINE_LOCATION)) {

        Snackbar.make(((Activity)mContext).getWindow().getDecorView().findViewById(android.R.id.content),
                ((Activity)mContext).getResources().getString(R.string.location_permission_rationale), Snackbar.LENGTH_INDEFINITE)
                .setAction(android.R.string.ok, new View.OnClickListener() {
                    @Override
                    @TargetApi(Build.VERSION_CODES.M)
                    public void onClick(View v) {
                        requestPermissions((Activity)mContext, new String[]{ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
                    }
                });
    } else {
        requestPermissions((Activity)mContext, new String[]{ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
    }
    return false;
}