@Entity
@Cacheable(true)
public class Employee {
    @Id
    @Column(name="EMP_ID")
    private long id;
    ...
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy="owner")
    private List<Phone> phones;
    ...
}