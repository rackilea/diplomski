@Entity
public class Student{
    public List<Course> getCourses(){
        return courses;
    }
    public void setCourses(List<Course> courses){
        this.courses = courses;
    }
    @OneToMany(mappedBy="student")
    private List<Course> courses;
}

@Entity
public class Course{
    @ManyToOne(optional=false)
    private Student student;
    @ManyToOne(optional=false)
    private Grade grade;
    public void setStudent(Student student){
        this.student = student;
    }
    public Student getStudent(){
        return student;
    }
    public Grade getGrade(){
        return grade;
    }
    public void setGrade(Grade grade){
        this.grade = grade;
    }
}

@Entity
public class Grade{
    @OneToMany(mappedBy="grade")
    private Set<Course> courses;
    public void setCourses(Set<Course> courses){
        this.courses = courses;
    }
    public Set<Course> getCourses(){
        return courses;
    }
}