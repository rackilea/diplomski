@Embeddable 
public class Accounts implements Serializable {
  private Date nextDue;
  private Date nextMadeUpTo;
  // implement proper equals/hashcode here
}

@Entity
public class Customer {
  // your normal things
  @ElementCollection
  private Set<Accounts> Accounts;
}