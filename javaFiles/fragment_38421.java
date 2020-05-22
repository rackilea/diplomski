@Entity
@Table(name = "student", catalog = "students")
public class Student implements java.io.Serializable {

    ...

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_career",referencedColumnName="career_name" nullable = false)
    private Career career;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_section", nullable = false)
    private Section section;

    ...
}