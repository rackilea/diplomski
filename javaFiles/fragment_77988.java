@Override
public void onClick(View arg0) {

    int available = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    if (available != ConnectionResult.SUCCESS) {
        showGoogleDialog();
        return;
    }
    try {
        mConnectionResult.startResolutionForResult(this, REQUEST_CODE_SIGN_IN);
    } catch (IntentSender.SendIntentException e) {
        mPlusClient.connect();
    } catch (NullPointerException e1) {
        PvrLog.d("null pointer exception");
    }
}