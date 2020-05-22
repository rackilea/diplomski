public interface DbOperation {
    public String thisOperation();
}

public abstract class Save implements DbOperation {
    public String thisOperation(){
        return "Save";
    }

    public void save(List<Object> pojoList);
    public void save(String query);
} 

public abstract class Update implements DbOperation{
    public String thisOperation(){
        return "Update";
    }

    public void update(List<Object> pojoList, List<String> conditionList);
    public void update(String query);
} 

public abstract class Delete implements DbOperation {
    public String thisOperation(){
        return "Delete";
    }

    public void delete(String query);
} 

class SaveOperation implements Save {
}

class UpdateOperation implements Update {
}