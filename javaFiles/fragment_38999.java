public class Student implements Comparable<Student>, Serializable {
    private int registrationNumber;
    private int coursework1;
    private int coursework2;
    private int finalExam;
    private int totalScore;

    public Student(int registrationNumber, int coursework1, 
                             int coursework2, int finalExam) {
        this.registrationNumber = registrationNumber;
        this.coursework1 = coursework1;
        this.coursework2 = coursework2;
        this.finalExam = finalExam;
        totalScore = coursework1 + coursework2 + finalExam;
    }

    ...
    // all you getters and setters
    ...



    public int compareTo(Student s){
        if (this.totalScore > s.totalScore)
            return 1;
        else if (this.totalScore == s.totalScore)
            return 0;
        else 
            return -1;
    }
}