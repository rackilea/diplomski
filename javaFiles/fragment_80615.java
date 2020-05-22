private enum Grade {
    FIRST_CLASS(3.5),
    TWO_ONE(3),
    TWO_TWO(2.5),
    PASS(2),
    FAIL(0);

    private final double minGPA;

    Grade(final double minGPA) {
        this.minGPA = minGPA;
    }

    static Grade getGradeFromGPA(double gpa) {
        for (Grade grade : Grade.values()) {
            if (gpa > grade.minGPA)
                return grade;
        }
        //invalid GPA
        return null;
    }
}