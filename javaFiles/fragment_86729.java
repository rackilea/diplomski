import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MultipleOverrides {

    public static void main(String args[]) {

        Student s1 = new Student(1, "A", 1);
        Student s2 = new Student(1, "A", 2);
        Student s3 = new Student(1, "A", 3);
        Student s4 = new Student(2, "B", 1);
        Student s5 = new Student(2, "B", 2);
        Student s6 = new Student(2, "B", 3);
        Student s7 = new Student(3, "C", 1);
        Student s8 = new Student(3, "C", 2);
        Student s9 = new Student(3, "C", 3);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);

        System.out.println("All students before sorting : " + students);

        TreeSet<Student> sortedStudents = new TreeSet<>();
        sortedStudents.addAll(students);
        System.out.println("All students after sorting : " + sortedStudents);

    }

}