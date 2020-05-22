class DBRow {
    public DBRow() { }
    public DBRow(Object obj) {
        initialize(obj);
    }
    public void insert() {
        actuallyAddRowToDatabase();
    }
}

class MyObject extends DBRow {
    MyObject(Object obj) {
        super(obj);
    }
    public void insert(Object obj) {
        doSomething(obj);
        insert();
    }
}

class Factory {
    static MyObject createObject(Object obj1, Object obj2) {
        MyObject newObj = new MyObject(obj1);
        newObj.insert(obj2);
        return newObj;
    }
}