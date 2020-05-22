@Override
public void onTabSelected(ActionBar.Tab tab,
    FragmentTransaction fragmentTransaction) {
  // When the given tab is selected, switch to the corresponding page in
  // the ViewPager.
  mViewPager.setCurrentItem(tab.getPosition());
  webView.loadUrl("http://feedit.themeister.se/"+tab.getText()+".php");
}