private void checkCurrentActivity() {
    final Activity currentActivity = GeoFortApplication.getCurrentActivity();
    if (currentActivity instanceof MainActivity) {
        ((MainActivity) currentActivity).switchTab();
    } else {
        currentActivity.finish();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(Constants.DEBUG, "CurrentActivity: " +  currentActivity.toString());
                    ((MainActivity) currentActivity).switchTab();
                } catch (ClassCastException e) {
                    Log.e(Constants.EXCEPTION, e.getLocalizedMessage());
                }
            }
        }, 5000);
    }
}