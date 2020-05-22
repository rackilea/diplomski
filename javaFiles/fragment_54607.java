private boolean mLoggedIn;
private MenuItem mItemLogIn;
private MenuItem mItemLogOut;

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    mItemLogIn = menu.add("Log In");
    mItemLogOut = menu.add("Log Out");

    //---set more properties--

    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    mItemLogIn.setVisible(!mLoggedIn);
    mItemLogOut.setVisible(mLoggedIn);
    return super.onPrepareOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if(item.equals(mItemLogIn)){
        //--login--
        mLoggedIn = true;
        invalidateOptionsMenu();
    }else if(item.equals(mItemLogOut)){
        //--log out--
        mLoggedIn = false;
        invalidateOptionsMenu();
    }
    return super.onOptionsItemSelected(item);
}