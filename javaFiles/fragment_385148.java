//add public before class  bcos of this not getting the value in my eclipse
public class DB_record implements Serializable {
    private String id;
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "db_datas{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}