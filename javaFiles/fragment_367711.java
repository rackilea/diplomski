@Entity
public class House implements Serializable {
    @Id
    private int id;

    @OneToMany(mappedBy="house")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Person> people;

    ... rest of your class
}