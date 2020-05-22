public class DataBaseLayer {
    public DataBaseLayer(SomeDBClass dbObject){
        this.dbObject = dbObject;
    }

    ...

    private void openSession() {
        dbObject.connect(username, password);
    }

    ...

    public Result runQuery(Query q){
    ...
}