public class StudentUnit{

    ...

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "studentUnit")
    private List<Unit> units;
}

@Entity
@Table(name="UNITS")
public class Unit {

    @Id
    @Column(name = "UNIT_CODE")
    private String unitCode;

    @ManyToOne
    @JoinColumn(name="STUDENT_NO_ID")
    private StudentUnit studentUnit;

    @Column(name = "UNIT_NM")
    private String unitNm;
}