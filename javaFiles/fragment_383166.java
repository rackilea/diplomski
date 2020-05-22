@Entity
@SequenceGenerator(name="book_seq", initialValue=1, 
                   allocationSize=10, sequenceName="BOOK_SEQ")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="book_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name="STUDENT_ID")
    private Student student;

    @Column(name="TITLE", nullable=false)
    private String title;

    ..................
    ..................
}