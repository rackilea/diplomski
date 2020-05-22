@Entity
@Table(name="employee")
@XmlType(name="employee")
public class Employee extends Person {

    @Override
    @XmlAttribute(name = "name")
    @Transient
    public String getName() {
        return super.getName();
    }

}