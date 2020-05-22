public static class MainActivity extends Activity implements Fragment2.OnButtonClickedListener {
    Fragment1 mFragment1;

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof Fragment2) {
            // Register the listener
            Fragment2 fragment2 = (Fragment2) fragment;
            fragment2.setOnButtonClickedListener(this);
        } else if (fragment instanceof Fragment1) {
            // Keep a reference to fragment 1 for calling the "download" method
            mFragment1 = (Fragment1) fragment;
        }
    }

    @Override
    public void onButtonClicked() {
        // Handle the button click
        mFragment1.startImageDownload();
    }
}