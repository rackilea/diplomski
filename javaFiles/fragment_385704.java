public class Course{
    @OneToMany(mappedBy="course")
    @OrderBy("name.firstName ASC")  
    private List students;
    .....
}