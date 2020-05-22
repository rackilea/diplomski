public class Homework {
    private String student;
    public Homework(String name) {
        student = name;
    }
    public String getStudent() {
        return student;
    }
}

public class StudentGrade extends Homework {
    private String grade;
    public StudentGrade(String grade, String name) {
        super(name);

        this.grade = grade;
    }
    public String getGrade() {
        return grade;
    }

}

public class HomeworkGrades {
    public List<StudentGrade> getGrades() {
         // this method isnt implemented but should
         // be finished to return array of grades
    }
}