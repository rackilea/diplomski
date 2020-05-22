public class Planet {

    public String name;

    public boolean filtered;

    private List<String> mChildren;

    private List<Boolean> mChildrenFiltered;

    private List<String> mChildrenShown;

    public Planet(String name, List<String> children) {
        this.name = name;
        mChildren = children;
        mChildrenFiltered = new ArrayList<>();
        for (String child : children) {
            mChildrenFiltered.add(false);
        }
        mChildrenShown = new ArrayList<>(children);
    }

    public int getChildrenCount() {
        return mChildrenShown == null ? 0 : mChildrenShown.size();
    }

    public String getChild(int position) {
        return mChildrenShown.get(i);
    }

    public void filter(String child, boolean filter) {

        mChildrenShown.clear();
        for (int i = 0; i < mChildren.size(); i++) {

            if (mChildren.get(i).equals(child)) {
                mChildrenFiltered.set(i, filter);
            }

            if (! mChildrenFiltered.get(i)) {
                mChildrenShown.add(mChildren.get(i));
            }
        }

    }
}