import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
    private String name;
    private int test;
    private int quiz;

    public Student(String name, int test, int quiz) {
        this.name = name;
        this.test = test;
        this.quiz = quiz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}

public class Stack {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Willian", 90, 80));
        students.add(new Student("Charles", 70, 95));

        Collections.sort(students);

        System.out.println("\t\t   Test \tQuiz");
        for (Student s : students) {
            System.out.println(String.format("%s\t\t%d\t\t%d", s.getName(), s.getTest(), s.getQuiz()));
        }
    }
}