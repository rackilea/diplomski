static Grade getGradeFromGPA(double gpa) {
    for (Grade grade : Grade.values()) {
        if (gpa > grade.minGPA)
            return grade;
    }
    //invalid GPA
    throw new IllegalArgumentException();  // <----------
}