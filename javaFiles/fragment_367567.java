public class MyIndexedListClass {
    private List<String> myIndexedListClass = new ArrayList<String>();

    public String getMyIndexedListClass(int index) {
        return myIndexedListClass.get(index);
    }

    public void setMyIndexedListClass(int index, String element) {
        this.myIndexedListClass.set(index, element);
    }

    public List<String> getMyIndexedListClassAsList() {
        return myIndexedListClass;
    }

    public void setMyIndexedListClassAsList(List<String> myIndexedListClass) {
        this.myIndexedListClass = myIndexedListClass;
    }
}