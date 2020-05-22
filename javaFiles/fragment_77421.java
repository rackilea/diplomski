public class MyUtils {

    @Autowired MyObjectContainer myObjectContainer;

    public void setMyObjectFromDB() {
        MyObject myDBObject = new MyObject();
        //
        // getting myObjectFromDB;
        //
        myObjectContainer.setMyObject(myDBObject);
    }

    public MyObjectContainer getMyObjectContainer() {
        return myObjectContainer;
    }
}