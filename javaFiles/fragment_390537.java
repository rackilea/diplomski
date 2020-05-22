public class MyListModel extends AbstractListModel {

    private final ArrayList<MyObject> myArrayList = new ArrayList<MyObject>();

    public void addElement(MyObject obj) {
        myArrayList.add(obj);
        fireIntervalAdded(this, myArrayList.size()-1, myArrayList.size()-1);
    }

    @Override
    public Object getElementAt(int index) { return myArrayList.get(index); }

    @Override
    public int getSize() { return myArrayList.size(); }
}