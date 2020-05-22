@Table(name="USER")
public class User() {

      @Id
      private Integer id;

      @ManyToMany
      @JoinTable(
        name="USER_GROUP",
        joinColumns={@JoinColumn(name="USER_ID")},
        inverseJoinColumns={@JoinColumn(name="GROUP_ID")})
      private List<Group> groups;
      ...

  }