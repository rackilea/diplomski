@Entity
public class Employee {
  @Id
  private long id;

  @Embedded
  private EmploymentPeriod period;
}

@Embeddable
public class EmploymentPeriod {
    @ManyToOne //owning relationship
    @JoinColumn //FK in EMPLOYEE table (by default: ENTITYABCD_ID) 
    private EntityABCD entityABCD;

    @ManyToMany //owning relationship
    @MapKey(name="id") //refers to EntityABCD.id
    @JoinTable //FK in the join table (by default: EMPLOYEE_ENTITYABCD)
    private Map<Long, EntityABCD> entitiesABCD;
}

@Entity
public class EntityABCD {
    @Id
    private long id;

    @OneToMany(mappedBy = "period.entityABCD") //non-owning relationship
    List<Employee> employee;

    @ManyToMany(mappedBy="period.entitiesABCD") //non-owning relationship
    private List<Employee> employees;
}