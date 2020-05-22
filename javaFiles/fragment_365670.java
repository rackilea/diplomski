@Entity
@Access(AccessType.PROPERTY)
public class Employee {
    private EmployeePK primaryKey;

    @ManyToOne
    @MapsId("id")
    @Access(AccessType.FIELD)
    private ClassWithPKid fkobject1;

    @EmbeddedId
    public EmployeePK getPrimaryKey() {
        return primaryKey;
    }
}