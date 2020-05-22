FragmentManager mgr = getFragmentManager();
if (mgr.findFragmentByTag("start") == null &&
    mgr.findFragmentByTag("replacementTest") == null) {

    FragmentTransaction t = mgr.beginTransaction();
    t.add(R.id.fragment_container, startingFragment, "start").commit();             

}