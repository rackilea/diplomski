public static void NewInstance(LoginActivity activityContext, Constants constantsObj) {
    clsConstantsObj = constantsObj;
    urlToCatch = clsConstantsObj.toString();
    urlToCatch = urlToCatch.replace("/params", "");

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    activityContextInFragment = activityContext;

    fragmentManager = activityContext.getSupportFragmentManager();

    AuthFragment findAuthFragment = (AuthFragment) fragmentManager
            .findFragmentByTag("authFragment");

    if (findAuthFragment == null) {
        AuthFragment authFragment = new AuthFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainviewRegionwise, authFragment, "authFragment");
        fragmentTransaction.commit();
    }
}