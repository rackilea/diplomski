@Entity
@Table(name = "Student")
public class Student
{
    /*...*/

    @OneToMany
    @Filter(name = "active", condition = "EXISTS(SELECT * FROM Study s WHERE state = true and s.id = study_id)")
    Set<StudentStudy> studies;

    /* getters and setters methods */
}