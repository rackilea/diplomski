static final Map<String, Double> gradeToPointMap =
        new LinkedHashMap<String, Double>() {{
            put("A+", 4.0);
            put("A", 4.0);
            put("A-", 3.67);
            put("B+", 3.33);
            put("B", 3.0);
            put("B-", 2.67);
            put("C+", 2.33);
            put("C", 2.0);
            put("F", 0.0);
        }};

public static void main(String... args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter a letter grade as one of " + gradeToPointMap.keySet());
    String letterGrade = keyboard.next();

    Double gradePoints = gradeToPointMap.get(letterGrade.toUpperCase());
    if (gradePoints == null)
        System.out.println("Unknown letter grade " + letterGrade);
    else
        System.out.println("Your grade point(GPA) is " + gradePoints);
}