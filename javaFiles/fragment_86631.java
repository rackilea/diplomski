@Entity
public class Parent {
    @Id
    @Column(name="PARENT_ID")
    private long parentId;

    @Column(name="NAME")
    private String name;

    @OneToMany(mappedBy="parent")
    @Filter(name="gender", condition="gender.genderInd=:gender")
    private Set<Child> children
}

@Entity
@FilterDef(name="genderFilter", parameters=@ParamDef( name="gender", type="string" ) )
public class Child {
    @Id
    @Column(name="CHILD_ID")
    private long childId

    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name="GENDER_ID")
    private Gender gender;
}