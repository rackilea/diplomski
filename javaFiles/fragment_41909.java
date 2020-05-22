@Entity
public class Registration{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @Basic
    private String name;

    // getters and setters

}