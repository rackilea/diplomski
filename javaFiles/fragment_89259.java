class EntryListContainer {

    private List<Entry> children;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntryList1(List<Entry> entryList1) {
        this.children = entryList1;
    }

    public List<Entry> getEntryList1() {
        return children;
    }
}