@Override
public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    // When the given tab is selected, switch to the corresponding page in
    // the ViewPager.
    mViewPager.setCurrentItem(tab.getPosition());

    if (fragmentFirst != null){
       Bundle bundle = new Bundle();
       bundle.putSerializable("sets", sets);
       //fragmentFirst.setArguments(bundle); //not working
       fragmentFirst.updateArguments(bundle); //try this
    }

}