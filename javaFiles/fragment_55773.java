@Entity
@Table(name = User) // I'm guessing a table name
public class User{
    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Student student;

    @OneToMany(mappedBy = "teacher",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Teacher teacher;
}