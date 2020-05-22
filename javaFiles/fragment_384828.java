public class Foo {
    private final Map map;

    public Foo(....) {
        map = new HashMap();
        // populate
    }

    public Map getMap() {
        // If the 'map' is final, and nothing changes it apart from 
        // the constructor, this method doesn't need to be synchronized.
    }