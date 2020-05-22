public class MyClass<T extends List<? extends Number>> {
    T myList;

    public T getMyList() {
        return myList;
    }

    public void setMyList(T myList) {
        this.myList = myList;
    }
}

public class Tester {
    public Tester() {
        MyClass<ArrayList<Number>> list = new MyClass<>();
        list.setMyList(new ArrayList<>());
        list.getMyList().add(new Integer(2));
        list.getMyList().add(new Long(3));
    }
}