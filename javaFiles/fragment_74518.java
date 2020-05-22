// this code inside your onReceive()
String data = intent.getStringExtra("Status");
Fragment fragment = getTopVisibleFragment(getSupportFragmentManager(),R.id.fragment_container);
if (fragment != null && fragment instanceof DialogFragment) {
      fragment.setData(data);
}


public static Fragment getTopVisibleFragment (FragmentManager manager, int containerId) {
    return manager.findFragmentById(containerId);
}