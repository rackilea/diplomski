@Table(name="GROUP")
public class Group(){

      @Id
      private Integer id;

      @JoinTable(
        name="USER_GROUP",
        joinColumns={@JoinColumn(name="GROUP_ID")},
        inverseJoinColumns={@JoinColumn(name="USER_ID")})
      private List<Users> users;
      ...

 }