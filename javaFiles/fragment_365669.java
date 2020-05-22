@Entity
@Access(AccessType.PROPERTY)
public class Employee {
    private EmployeePK primaryKey;

    private ClassWithPKid fkobject1;

    @EmbeddedId
    public EmployeePK getPrimaryKey() {
        return primaryKey;
    }

    @ManyToOne
    @MapsId("id")
    public ClassWithPKid getFkobject1() {
        return fkobject1;
    }
}