@Entity 
@IdClass(TableA_PK.class)
public class TableA implements Serializable {
    @Id
    private int fId;
    @Id
    private String item;
    @Id
    private String release;
    @Id
    @ManyToOne
    @JoinColumn(name="b_id")
    private TableB tableB;
    @Column
    private String field1;
    @Column
    private String field2;