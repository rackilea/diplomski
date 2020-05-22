public class DBtest{
    // arguments are passed using the text field below this editor
    public static void main(String[] args){
        DataBase database = new DataBase(new Oracle("test"));

        DatabaseName databaseName = database.getDataBase();

        System.out.println(databaseName.getName());
    }
}

interface DatabaseName {
    String getName();
}

class DataBase{
    private DatabaseName databaseName;

    public DataBase(DatabaseName databaseName){
        this.databaseName = databaseName;
    }

    public DatabaseName getDataBase(){
        return databaseName;
    }
}


class Oracle implements DatabaseName {
    private String _databaseName;

    public Oracle(String name){
        _databaseName = name;
    }

    public String getName() {
        return _databaseName;
    }
}

class MongoDB implements DatabaseName {
    private String _databaseName;

    public MongoDB(String name){
        _databaseName = name;
    }

    public String getName() {
        return _databaseName;
    }
}