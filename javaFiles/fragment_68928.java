@Entity
@Table(name= "Mur_Follower")
public class Follower {

    @Id
    @Column(name="follower_id")
    private Integer id;
    @Column(name="mur_id")
    private Mur mur;

 @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name= "Wall_Follower",
        joinColumns = { @JoinColumn(name = "follower_id") },
        inverseJoinColumns = { @JoinColumn(name = "wall_id") }
    )
    private Set<Wall> walls;