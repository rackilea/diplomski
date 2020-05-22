@Entity
@Table(name = "users")
public class User implements Serializable {
   ...

   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date birthday;
   ...
}