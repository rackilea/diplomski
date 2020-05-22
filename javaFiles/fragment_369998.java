@Entity
public class SomeEntity {
    @Id
    private int id;

    @Column(name="DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateCreated;

    public SomeEntity(int id, Date dateCreated) {
        this.id = id;
        this.dateCreated = dateCreated;
    }
    public SomeEntity() {
    }
}