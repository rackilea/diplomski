public class MainFragment extends Fragment {

 private class HomeFragmentListener implements HomeFragment.HomeFragmentActionListener {
public void onButtonClick(int pos) {
 //Change the tabs.
}
}
and set the listener in setupviewpager
private void setupViewPager(ViewPager viewPager) { 
Adapter adapter = new Adapter(getChildFragmentManager()); 
HomeFragment homeFragment = new HomeFragment(); 
homeFragment.setListener( new HomeFragmentListener()); 
adapter.addFragment(homeFragment, this.getString(R.string.Homecap)); 
..