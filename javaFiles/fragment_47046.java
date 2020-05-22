@Entity
@Table(name="users")
public class User {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="userid")
   protected Long id = null;
   @ManyToMany
   @JoinTable(name = "user_friends", 
       joinColumns = @JoinColumn(name = "user_id"), 
       inverseJoinColumns = @JoinColumn(name = "friend_id"))
   protected List friends = null;
   @ManyToMany(mappedBy = "friends")
   protected List befriended = null;
}