@Entity
@Table(name="STUDENT")
@SequenceGenerator(name="student_seq", initialValue=1, 
                   allocationSize=10,sequenceName="STUDDENT_SEQ")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="student_seq")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="student")
    @OrderColumn(name="FOLLOWUP_NUMBER")
    private List<Book> books = new ArrayList<>();

    ...............
    ...............
}