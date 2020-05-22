@Entity
public class Color {


    @Id
    @GeneratedValue
    private Integer id;

    private String color;

    @ManyToMany(mappedBy = "colors", cascade = CascadeType.ALL)
    private List<Person> persons;
   /// setters getters are there
}