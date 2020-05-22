private List<SurfacePanelFragment> fragments = new ArrayList<>(PAGE_COUNT);

    @Override
    public SurfacePanelFragment getItem(int position) {
        if (fragments.get(position) == null) {
            fragments.set(position, SurfacePanelFragment.newInstance());
        }
        return fragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return (fragments.contains(object)) ? POSITION_UNCHANGED : POSITION_NONE;
    }

    public void invalidateFragment(int position) {
        fragments.set(position, null);
        notifyDataSetChanged();
    }

    private static final int PAGE_COUNT = 2;