public class Student {
    String name;
    String groupNumber;
    Exam exam = new Exam();

    public Student() {
    }

    public Student(String name, String groupNumber, Exam exam) {
        super();
        this.name = name;
        this.groupNumber = groupNumber;
        this.exam = exam;
    }

    public String getName() {
        return name;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public Exam getExam() {
        return exam;
    }

    public String getExamName() {
        return exam.getName();
    }

    public int getExamMark() {
        return exam.getMark();
    }

}

public class Exam {
    String name;
    int mark;

    public Exam() {
    }

    public Exam(String name, int mark) {
        super();
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}