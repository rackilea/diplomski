public class Clazz {

    public static void main(String[] args) {
        MyObject myObject = MyObject.getInstance();
    }
}

class MyObject {
    private static MyObject instance; 
    //I belong to the class, but I need not be created before somebody wants me.

    private MyObject() {
    }

    public static MyObject getInstance() {
        if (instance == null) {
            instance = new MyObject();
        }
        return instance;
    }
}