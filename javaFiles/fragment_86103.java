@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);

    /* savedInstanceState Bundle will be passed onto onCreate() when activity
     * gets killed and restarted. */
     savedInstanceState.putSerializable("userModel", userModel);
}

@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    /* Also being passed onto onCreate(). */
    UserModel mUserModel = (UserModel) savedInstanceState.getSerializable("userModel");
}