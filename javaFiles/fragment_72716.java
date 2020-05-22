@Entity
@Table(name = "make")
@PrimaryKeyJoinColumn(name="make_id")
public class Make {
    @Id
    @Column(name = "make_id")
    private String makeId;

    @Column(name = "make_name")
    private String makeName;

    // ** introduced new relationship **
    @OneToMany(mappedBy="make", fetch = FetchType.LAZY)
    private List<Model> models;

    @ManyToOne
    @JoinColumn(name = "mfg_unit_id")
    private MfgUnit mfgUnit;

    // Getter and Setters
}