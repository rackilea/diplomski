@Entity
@Table(name="PERSON")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person implements Serializable {
    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
}

@Entity
@Table(name="CHILD")
@PrimaryKeyJoinColumn(name="nameId", referencedColumnName = "id")
private class Child extends Person implements Serializable {
    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Person parent;
}