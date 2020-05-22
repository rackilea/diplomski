class Category {

    private ArrayList<String> mEntries = new ArrayList<String>();
    private String mCaTegoryName;

    public void addEntry(String entry) {
        mEntries.add(entry);
    }

    public void setCategoryName(String categoryName) {
        mCaTegoryName = categoryName;
    }

    public ArrayList<String> getEntries() {
        return mEntries;
    }

    public String getCategoryName() {
        return mCaTegoryName;
    }
}