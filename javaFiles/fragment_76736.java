@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == Activity.RESULT_OK) {
        myFragment.updateData(data.getString(NEW_BUTTON_TEXT));
        // Need to use commitAllowingStateLoss() to prevent an IllegalStateException 
        // from being thrown
        getSupportFragmentManager()
            .beginTransaction()
            .detach(mContactDetailsFragment)
            .attach(mContactDetailsFragment)
            .commitAllowingStateLoss();
    }
}