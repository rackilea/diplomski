import org.codehaus.jackson.annotate.JsonIgnore;
class User {

    long id;
    String name;
    String password;
    String field1;
    String[] array1;

    @JsonIgnore
    public String[] getArray1() {
        return array1;
    }

    @JsonIgnore
    public void setArray1(String[] array1) {
        this.array1 = array1;
    }

    public String getField1() {
        return field1;
    }

    @JsonIgnore
    public void setField1(String field1) {
        this.field1 = field1;
    }

    public long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}