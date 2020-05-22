@Override
public void onBackPressed() {

    if(getFragmentManager().getBackStackEntryCount() > 0) {
        getFragmentManager().popBackStackImmediate();
    }

    else {
        super.onBackPressed();
        finish();
    }
}