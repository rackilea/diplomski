@Table(name="PERSONS") @Entity public class Persons {
  @Id @Column(name="ID") long id;
  @Column(name="NAME") String name;
  @Column(name="TYPE") BaseEnum type;   // known to be "PersonTypeEnum"

  public PersonType getType() {
    switch(type.getValue()) {
      case "EMPLOYEE": return PersonType.EMPLOYEE;
      case "MANAGER":  return PersonType.MANAGER;
    }
    throw new IllegalStateException(); 
  }

  public void setType(PersonTypeEnum type) {
    this.type = type;
  }
  // ...
}

@Entity @Inheritance @DiscriminatorColumn(name="ENUM") @Table(name="ENUMS")
public abstract class BaseEnum {
  @Id private int id;
  @Column(name="VALUE") String value;
  // ...
}

@Entity @DiscriminatorValue("PERSON_TYPE")
public class PersonTypeEnum extends BaseEnum { }