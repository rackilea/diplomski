@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    ...         
    @OneToMany
    private List<Post> posts;
    ...
}

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    ...
    @ManyToOne
    private User author;
    ...
}