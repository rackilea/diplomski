@Override
public void onViewerSelected(Long id) {
     SfnViewerFragment sfnViewerFragment = (SfnViewerFragment)
     getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.pager + ":0"); 
     sfnViewerFragment.getWebView(id);
}