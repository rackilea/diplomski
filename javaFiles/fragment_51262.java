public class MyObject {
    MyOtherObject myOtherObject;
    public void runThis() {
        myOtherObject = new MyOtherObject();
        MyCustomObjectTracker customObjectTracker = new MyCustomObjectTracker() {
            @Override
            public void closingMyWindows() {
                myOtherObject.doClose();
            }
        };
    }
}