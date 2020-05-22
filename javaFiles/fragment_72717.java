@Entity
@Table(name = "model")
public class Model {
    @Id
    @Column(name = "model_id")
    private String modelId;

    // change the datatype as Date or similar Datatype
    @Column(name = "model_creation_date")
    private Date modelCreationDate;

    @Column(name = "make_id")
    private long makeId;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

    // Getter and Setters
}