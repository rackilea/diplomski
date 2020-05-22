@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Teen teen;
}