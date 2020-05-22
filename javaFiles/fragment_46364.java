@Entity
@Table(name = "tbl_thread")
public class Thread implements Serializable {
        @Id
        @GeneratedValue
        private Long id;
        @Column(name = "threadid")
        private String threadID;
        @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
        @JoinColumn(name = "threadid")
        private List<Tweet> listOfTweets;