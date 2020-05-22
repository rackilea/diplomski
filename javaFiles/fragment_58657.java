public class SampleAdapter extends FragmentPagerAdapter {
Context ctxt=null;

public SampleAdapter(Context ctxt, FragmentManager mgr) {
    super(mgr);
    this.ctxt=ctxt;
}

  @Override
    public int getCount() {
    return(10);
  }

  @Override
    public Fragment getItem(int position) {
    return(EditorFragment.newInstance(position));
  }

  @Override
    public String getPageTitle(int position) {
    return(EditorFragment.getTitle(ctxt, position));
  }
}