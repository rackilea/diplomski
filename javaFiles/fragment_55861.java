@Table(name = "users")
public class Users {
    @PartitionKey
    public UUID id;
    //...
}