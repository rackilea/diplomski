ActionBar actionBar = getActionBar();
actionBar.addTab(actionBar.newTab().setText("Your Tab").setTabListener(new ActionBar.TabListener()
{
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
    {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
    {

    }
}));