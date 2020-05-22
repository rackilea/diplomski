@Entity
@Table(name = "users")
@Document(collection="users")
@Data
public class Users {

    @Id
    @javax.persistence.Id
    private String id;
    private String name;
    private Integer age;

}