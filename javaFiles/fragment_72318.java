@Entity
  public class MyUser {

    @Id
    private Long id;
    private String username;
    private String password;
    private boolean isEnabled;

    @ManyToMany
    private List<MyAuthority> myAuthorities;
    ...
  }