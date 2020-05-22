@Entity
@Table(name = "user_post_rate")
public class UserPostRate {

    @OneToMany
    private Post post;
    @OneToOne
    private User user;
    private boolean upvote;
    // ...
}