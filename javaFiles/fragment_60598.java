@Entity
@Access(AccessType.FIELD)
@Table(name="PARENT")
@SequenceGenerator(name="abstract_generator",sequenceName="parent_seq",allocationSize=10)
@NamedQuery(name="parent.findAll",query="select q from parent q")
public class Parent extends Root{

@Column(name="Name")
private String name;

public void setName(String name){
this.name=name;
}
}