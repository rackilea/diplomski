@Entity
@Table(name = "USERS")
public class Profile implements Serializable {


        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name="following", 
                joinColumns={@JoinColumn(name="user_id")}, 
                inverseJoinColumns={@JoinColumn(name="follower_id")})
        private Set<Profile> followers = new HashSet<Profile>();

        @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL)
        private Set<Profile> followBy = new HashSet<Profile>();
}