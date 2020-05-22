public class Student {
    private Lecture[] lecture;

    public void setStudentLecture(Lecture[] lecture) {
        this.lecture = lecture;
    }

    public Lecture[] getStudentLecture() {
        return lecture;
    }

    public static void main(String[] args) {
        Student student = new Student();
        Lecture[] lectures = new Lecture[3];
        lectures[0] = new Lecture("Physics");
        lectures[1] = new Lecture("Mathematics");
        lectures[2] = new Lecture("Chemistry");

        student.setStudentLecture(lectures);

        Lecture[] lectures1 = student.getStudentLecture();
        for (int i = 0; i <lectures1.length; ++i) {
            System.out.println(lectures1[i].getName());
        }
    }
}

public class Lecture {
    private String name;
    public Lecture(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}