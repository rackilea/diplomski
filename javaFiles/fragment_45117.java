public class SectionsPagerAdapter extends FragmentPagerAdapter {

    List<String> tagList;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        tagList = new ArrayList<>();

    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.

        return PlaceholderFragment.newInstance(tagList.get(position));
    }

    @Override
    public int getCount() {

        return tagList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "SECTION "+(position+1);
    }

    public void add(int position, String key)
    {
        tagList.add(position, key);
        notifyDataSetChanged();
    }



}