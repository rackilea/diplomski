public void onTabSelected(Tab p_Tab, FragmentTransaction p_FragmentTransaction) 
{
    BaseClassGafitFragment v_Fragment = null;
    if(p_Tab.getPosition() == 0) 
        v_Fragment = new ModulesListFragment();
    else if(p_Tab.getPosition() == 1) 
        v_Fragment = new LocationsListFragment();
    else if(p_Tab.getPosition() == 2) 
        v_Fragment = new ScenesListFragment();
    else if(p_Tab.getPosition() == 3) 
        v_Fragment = new ScheduleListFragment();
    else if(p_Tab.getPosition() == 4) 
        v_Fragment = new UserFragment();
    if(v_Fragment != null)
        p_FragmentTransaction.replace(R.id.main_fragment_activity, v_Fragment);
}