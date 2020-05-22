@Entity
public class Student{
    // accessors and id omitted
    @OneToMany(mappedBy="student")
    private List<Grade> grades;
}

@Entity
public class Grade{
    // accessors and id omitted
    @ManyToOne
    private Student student;
}