Fragment f = (Fragment)getFragmentManager().findFragmentByTag("xyz_fragment");
if (f!=null && !f.isVisible() && !f.isAdded()) {

    ....

}