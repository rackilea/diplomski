public class MyObject {
    public void runThis() {
        MyOtherObject myOtherObject = new MyOtherObject();
        MyCustomObjectTracker customObjectTracker = new MyCustomObjectTracker() {
            @Override
            public void closingMyWindows() {
                myOtherObject.doClose();
            }
        };
    }
}