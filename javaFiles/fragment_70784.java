public class MyList {

    private Object[] backingArray;

    public void setBackingArray(Object[] backingArray) {
        this.backingArray = backingArray;
    }
}

public class MyListFactory() {

    MyList newMyList(int initialSize) {
         MyList list = new MyList();
         list.setBackingArray(new Object[initialSize]);
         return list;
    }



    MyList newMyList() {
         MyList list = new MyList();
         list.setBackingArray(new Object[defaultSize]);
         return list;
    }
}