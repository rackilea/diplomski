//Class which represents this "data storage" of yours. You can even have multiple instances of it simultaneously if you need
class Database {
    //Some data the DB contains
    private List<MyEntity> entities = new ArrayList<>();

    //Way to read the stored data
    public List<MyEntity> getEntities() {
        return entities;
    }

    //Way to add new data
    public void addEntity(MyEntity newEntity) {
        entities.add(newEntity);
    }
}

//Some working class, which fills the database with information
class EntityCreator {
    private final Database db;

    //Each working class attaches itself to specific database instance. Therefore, you need to pass that instance through the constructor and save it for later job
    public EntityCreator(Database operationalDb) {
        this.db = operationalDb;
    }

    public void writeSomeData() {
        for (.....) {
            db.addEntity(new MyEntity(...));
        }
    }
}

//Some working class, which depends on information saved in database
class EntityReader {
    private final Database db;

    //Each working class attaches itself to specific database instance. Therefore, you need to pass that instance through the constructor and save it for later job
    public EntityCreator(Database operationalDb) {
        this.db = operationalDb;
    }

    public void doSomeWork() {
        for (MyEntity e : db.getEntities()) {
            doStuff(e);
        }
    }
}

//Example of the full workflow
class MainClass {
    public static void main(String[] args) {
        Database db = new Database();
        EntityCreator creator = new EntityCreator(db);
        EntityReader reader = new EntityReader(db);

        creator.writeSomeData();
        reader.doSomeWork();
    }
}