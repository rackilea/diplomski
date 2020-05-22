public class CDStore implements ListModel {
    private String storeName;
    private List<CD> discsArray;
    private List<Person> peopleArray;

    public CDStore(String storeNme) {
        storeName = storeNme;
        discsArray = new ArrayList<CD>();
        peopleArray = new ArrayList<Person>();
    }

    //your methods

    //ListModel
    private List<ListDataListener> listener = new ArrayList<ListDataListener>();

    public void addListDataListener(ListDataListener l) {
        listener.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        listener.remove(l);
    }

    protected void fireContentsChanged() {
        for (ListDataListener l : listener) {
            l.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, discsArray.size()-1));
        }
    }

    public Object getElementAt(int index) {
        return discsArray.get(index);
    }

    public int getSize() {
        return discsArray.size()
    }
}