tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
{
    @Override
    public void onTabChanged(String tabId)
    {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);

    }
});