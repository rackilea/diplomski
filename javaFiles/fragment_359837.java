public class Student {

    private final String name;
    private int grade;
    private Student next;

    private static int counter = 0;

    public Student(Student template) {
        this.name = template.name;
        this.grade = template.grade;
    }

}