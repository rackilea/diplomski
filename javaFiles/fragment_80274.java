public class Student {
    private String name;
    private int grade;

    public String getName() {
        return name;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return "name:" + this.name + "grade:" + this.grade;
    }
}

public static void main(String[]args) {
    Student s1 = new Student("Jason", 73);
    Student s2 = new Student("Ricky", 64);
    Student s3 = new Student("Mark", 53);
    String[] names = {s1.getName(), s2.getName(), s3.getName()};
}