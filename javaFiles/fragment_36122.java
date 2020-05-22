@MappedSuperclass
public Class SuperClass {

    private int id;

    @ManyToOne
    private ClassB classB;

    private String code;
    private String name;

    @OneToMany
    private List<ClassD> listClassD;

}

@Entity
@Table(name = "table_name")
public Class ClassC extends SuperClass {

    // No Property

}

@Entity
@Table(name = "table_name")
public Class ClassE extends SupperClass {

    private String classECustomValue;

}