@Entity
@Table(name = "Person")
public class Person {
    .....

    @ManyToMany
    @JoinTable(
        name = "person_interest ", 
        joinColumns = { @JoinColumn(name = "personId") }, 
        inverseJoinColumns = { @JoinColumn(name = "interestId") }
    )
    private Set<Interest> interests = new HashSet();

    ..... other attributes and getter/setters
}