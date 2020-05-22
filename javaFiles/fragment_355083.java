public class CourseOffering {
    Student[] students;          
    String description;
    double homeworkAverage;
    double testAverage;
    int passingStudents;

    public CourseOffering() {
        this.students = new Student[100];          
        this.description = "";
        this.homeworkAverage = 0.0;
        this.testAverage = 0.0;
        this.passingStudents = 0;

    }