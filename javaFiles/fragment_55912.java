@Entity
@Table(name = "Teen")
public class Teen implements Serializable {

    @Id
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "teen")
    private User user;
}