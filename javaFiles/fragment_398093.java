@Entity
@Table(name = "Interest")
public class Interest{
    .....

    @ManyToMany
    private Set<Person> persons = new HashSet();

    ..... other attributes and getter/setters
}