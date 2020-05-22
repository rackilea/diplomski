public Searchable getSearchable() {
    if (searchable == null) {
        searchable = new TableSearchable(this);
    }
    return searchable;
}