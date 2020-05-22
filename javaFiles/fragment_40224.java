@Entity
public class Preferences implements Serializable {

@Id String id;

  @OneToOne @MapsId
  @JoinColumn
  private Client client;

}

// ...