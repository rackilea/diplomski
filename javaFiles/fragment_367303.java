@Entity
public class Student { /*...*/ }

@Entity
public class Category { /*...*/ }

@Entity
public class StudentCategory {
    @Id
    private Long id;

    @Index
    private Ref<Student> student;

    @Index
    private Ref<Category> category;

    /*...*/
}