@Entity
@Table(name = Studend) // I'm guessing a table name
public class Student{
    @JoinColumn(name = "student_id", nullable = false)
    private User user;
}

@Entity
@Table(name = Teacher) // I'm guessing a table name
public class Teacher{
    @JoinColumn(name = "teacher_id", nullable = false)
    private User user;
}