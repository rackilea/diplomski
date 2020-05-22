@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "friendships", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
    @MapKey(name = "userName")
    private Map<String, User> friends;

    public User(){
        friends = new HashMap<String, User>();
    }

    //force clients through add/remove to maintain two-way friendship
    public Map<String, User> getFriends() {
        return Collections.unmodifiableMap(friends);
    }

    //assumes become mutual friends
    public void addFriend(User friend) {
        friends.put(friend.userName, friend);
        friend.friends.put(this.userName, this);
    }

    //assumes remove mutual friendship
    public void removeFriend(User friend) {
        friends.remove(friend.userName);
        friend.friends.remove(this.userName);
    }

    public User getFriend(String userName) {
        return friends.get(userName);
    }

    public void setUsername(String userName){
        this.userName = userName;
    }
}