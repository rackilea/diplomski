@Entity
@Table(name="users")
public class User{

  @Column(length=50)
  private String name;

  @OneToMany(mappedBy = "user")
  private List<UserPick> userPicks = new ArrayList<UserPick>();

}

@Entity
@Table(name="usersPicks")
public class UserPick {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinnColumn(name = "fk_user") 
  private User user;

}