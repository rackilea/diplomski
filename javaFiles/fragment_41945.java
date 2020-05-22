public class Foo {
    public void insertRecords(List<Record> records){
        Service myService = new Service();
        for (Record record : records){
            myService.insertIntoAAndB(record);
        }
    }
}

public class Service {
    MyDAO dao;

    @Transactional (rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insertIntoAAndB(Record record){
        insertIntoA(record);
        insertIntoB(record);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertIntoA(Record record){
        dao.insertIntoA(record);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertIntoB(Record record){
        dao.insertIntoB(record);
    }

    public void setMyDAO(final MyDAO dao) {
        this.dao = dao;
    }
}