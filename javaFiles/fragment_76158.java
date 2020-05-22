public class Foo {
    public void createBaseAdapter() {
        ArrayList arList = new ArrayList();
        BaseAdapter ba = new BaseAdapter(arList);
    }
}

public class BaseAdapter {
    ArrayList arList;
    public BaseAdapter(ArrayList arList) {
        this.arList = arList;
    }
}