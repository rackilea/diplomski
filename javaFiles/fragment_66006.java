public class Student {
    public int studentID;
    public String courseName;
    public int courseScore;

    public Student() {
        this(1, "CIS 2085", 89);
    }

    public Student(int id, String course, int score) {
        this.studentID = id;
        this.courseName = course;
        this.courseScore = score;
    }

    @Override
    public String toString() {
        return studentID + " " + courseName + " " + courseScore;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseScore() {
        return courseScore;
    }


    public char getCourseGrade() {
        if (courseScore >= 94) {
            return 'A';
        } else if (courseScore >= 85 && courseScore <= 93) {
            return 'B';
        } else if (courseScore >= 75 && courseScore <= 84) {
            return 'C';
        } else if (courseScore >= 65 && courseScore <= 74) {
            return 'D';
        }
        return 'E';
    }

}