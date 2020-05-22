@Data
@Entity
public class Subscription {

    @Id
    @GeneratedValue
    @Column(name = "subscription_id")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscription_tag",
        joinColumns = { @JoinColumn(name = "subscription_id") },
        inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Tags> tags = new HashSet<>();

    private String subscriberString;

}