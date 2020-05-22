public class Test {

    // used when you want to refresh the cached object
    private static boolean refreshNext = false;

    // a static reference to your object that all threads can use
    private static MyObj cachedObj = null;

    private static void message(String msg) {
        System.out.println(
                System.currentTimeMillis() + " : " + Thread.currentThread().getName() + " : " + msg);
    }

    private static void sleep(long milli) {
        try { Thread.sleep(milli); } catch (Exception e) { }
    }

    // represents the object stored in the db
    private static MyObj myObjInDb = null;

    private static void saveObjInDb(MyObj obj) {
        // TODO do real saving to db and handle errors
        message("storing in db...");
        myObjInDb = obj;
    }

    private static MyObj loadObjFromDb() {
        // TODO do real loading from db and handle errors
        message("getting from db...");
        sleep(1000);
        return myObjInDb;
    }

    private static MyObj loadObjFromVendor() {
        // TODO do real fetching from vendor and handle errors
        message("getting from vendor...");
        sleep(2000);
        return new MyObj();
    }

    private static MyObj loadObj() {
        message("loading object...");
        MyObj obj = loadObjFromDb();
        if (obj == null) {
            message("db didn't have it.");
            obj = loadObjFromVendor();
            saveObjInDb(obj);
        }
        return obj;
    }

    /** Returns the object, first loading and caching if needed. */
    public static synchronized MyObj getObj() {
        // only one thread can get the object at a time, in case it needs to be loaded. 
        if (cachedObj == null || refreshNext) {
            // load and cache the object
            cachedObj = loadObj();
            refreshNext = false;
        }
        return cachedObj;
    }

    public static void exampleMethod() {
        MyObj obj = getObj();
        message(obj.toString());
        // ... do stuff with obj
    }

    private static class MyObj {
        public final String data = "I have data!";
        @Override public String toString() { return data; }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            new Thread(Test::exampleMethod).start();
    }
}