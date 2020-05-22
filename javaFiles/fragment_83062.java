public class Teacher  {

    @OneToMany(mappedBy = "teacher")
    private Set<Student> students;

    @Column(name = "name")
    private String name;
}

public class Student {
    @ManyToOne
    @JoinColumn(name = "teacherName", referencedColumnName = "name")
    private Teacher teacher;

}