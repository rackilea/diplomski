final String tag = MyFragment.TAG;
final FragmentManager fm = getSupportFragmentManager();
final Fragment fragFragment = fm.findFragmentByTag(tag);
if (fragFragment != null) {
    frag = (MyFragment) fragFragment ;
    frag.MyMethodInFragment();
}