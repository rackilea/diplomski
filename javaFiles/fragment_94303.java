public class MyWrapper {

    @ElementList(name="data")
    private List<MyClass> data = new ArrayList<MyClass>();

    public MyWrapper(List<MyClass> data) {
        this.data = data;
    }

    public List<MyClass> getData() {
        return this.data;
    }

    public void setData(List<MyClass> data) {
        this.data = data;
    }

}