public class DBtest{
    public static void main(String[] args){
        DataBase<Oracle> database = new DataBase<>(Oracle.class);

        Oracle oracle = database.getDataBase();

        System.out.println(oracle.getDatabaseName());
    }
}

class DataBase<T>{
    private T database;

    public DataBase(Class<T> classOfT){
        try {
            database = classOfT.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public T getDataBase(){
        return database;
    }
}


class Oracle{
    private String _databaseName;

    public Oracle(){
        _databaseName = "test";
    }

    public String getDatabaseName() { return _databaseName; }
}