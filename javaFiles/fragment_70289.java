@DatabaseTable(tableName = "bills")
public class Bill {
    public static final String ACCOUNT_ID_FIELD_NAME = "client_id";
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, columnName = ACCOUNT_ID_FIELD_NAME)
    private Client client;
    @DatabaseField 
    private String code;
    Client client; 
    List<Item> items;

    public Bill(){

    }
    public Bill(Client client, String code){
        this.client = client;
        this.code = code;
    }

    public int getId(){
        return this.id;
    }
    public String getCode(){
        return this.code;
    }
}

@DatabaseTable(tableName = "clients")
class Client {
    public static final String NAME_FIELD_NAME = "name";
    public Client() {
        // all persisted classes must define a no-arg constructor with at least package visibility
    }
    public Client(String name) {
        this.name = name;
    }
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false) 
    private String name;

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
}