try {
    Grade grade = Grade.getGradeFromGPA(gpa);
    switch (grade) {
        case FIRST_CLASS:   System.out.println("First class Hons"); break;
        case TWO_ONE:       System.out.println("upper Second class Hons"); break;
        case TWO_TWO:       System.out.println("Lower Second class Hons"); break;
        case PASS:          System.out.println("Pass"); break;
        case FAIL:          System.out.println("Fail"); break;
    }
} catch (IllegalArgumentException e) {
    System.out.println("Invalied GPA");
}