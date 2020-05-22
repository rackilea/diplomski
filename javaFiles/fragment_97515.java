import java.util.HashMap;

public class Example {

    public static void main(String[] argv) {
        Example ex = new Example();
        ICacheable[] cacheableObjects = new ICacheable[]{new MyObject(), new OtherObject()};

        for (ICacheable iCacheable : cacheableObjects) {
            // depending on whether the object is a MyObject or an OtherObject,
            // the .put(Example) method will double dispatch to either
            // the put(MyObject) or  put(OtherObject) method, below
            iCacheable.put(ex);
        }

        System.out.println("myObjects: "+ex.myObjects.size());
        System.out.println("otherObjects: "+ex.otherObjects.size());
    }

    private HashMap<String, MyObject> myObjects = new HashMap<String, MyObject>();
    private HashMap<String, OtherObject> otherObjects = new HashMap<String, OtherObject>();

    public Example() {

    }

    public void put(MyObject myObject) {
        myObjects.put(myObject.getKey(), myObject);
    }

    public void put(OtherObject otherObject) {
        otherObjects.put(otherObject.getKey(), otherObject);
    }

}

interface ICacheable {
    public String getKey();
    public void put(Example ex);
}

class MyObject implements ICacheable {

    public String getKey() {
        return "MyObject"+this.hashCode();
    }

    public void put(Example ex) {
        ex.put(this);
    }
}

class OtherObject implements ICacheable {

    public String getKey() {
       return "OtherObject"+this.hashCode();
    }

    public void put(Example ex) {
        ex.put(this);
    }

}