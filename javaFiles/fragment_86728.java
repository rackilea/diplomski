public class Student implements Comparable<Student> {

    private int studentId;
    private String studentName;
    private int studentSemester;

    public Student(int sId, String sName, int sSemester) {
        this.studentId = sId;
        this.studentName = sName;
        this.studentSemester = sSemester;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(int studentSemester) {
        this.studentSemester = studentSemester;
    }

    @Override
    public String toString() {
        return "[" + studentId + ", " + studentName + ", " + studentSemester + "]";
    }

    @Override
    public int compareTo(Student that) {
        if(this.getStudentId() == that.getStudentId())
            return 0;
        if(this.getStudentSemester() > that.getStudentSemester())
            return 1;
        if(this.getStudentSemester() < that.getStudentSemester())
            return -1;
        return 0;
    }

}