private void initFragment(){
    android.app.Fragment fragment;
    if(pref.getBoolean(Constants.IS_LOGGED_IN,false)){
        fragment = new ProfileFragment();
    }else {
        fragment = new LoginFragment();
    }
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    ft.replace(R.id.fragment_frame,fragment);
    ft.commit();
}