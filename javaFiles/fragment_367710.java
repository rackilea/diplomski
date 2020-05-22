@Entity
public class House implements Serializable {
    @Id
    private int id;

    @OneToMany(mappedBy="house")
    @Fetch(FetchMode.JOIN)
    private Set<Person> people;

    ... rest of your class
}