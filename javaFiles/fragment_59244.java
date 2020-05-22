@Override
protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (!isUserLoggedIn()) {
       finish();
       startActivity(getLoginActivity());
    } else {
       codeThatShouldNotBeExecutedWithoutUser();
    }
}