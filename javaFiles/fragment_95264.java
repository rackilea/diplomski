@Entity
public class Team implements Serializable {
    ...
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team", targetEntity = Player.class, fetch = FetchType.LAZY)
    @JsonView(FullView.class)
    private Collection<Player> players = new ArrayList<Player>();
    ...
}