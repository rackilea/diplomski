@Entity
public class Person {


    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(targetEntity = Color.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "person_color", joinColumns = { @JoinColumn(name = "person_id") }, 
                       inverseJoinColumns = { @JoinColumn(name = "color_id") })
    private List<Color> colors;
   /// setters getters are there
}