private static TreeMap<Double, String> gradeMap = new TreeMap<>();
static {
    gradeMap.put(85.0, "A");
    gradeMap.put(70.0, "B");
    gradeMap.put(60.0, "C");
    gradeMap.put(50.0, "D");
    gradeMap.put( 0.0, "F");
}
private static void printGrade(double score) {
    System.out.printf("Average exam score: %s Grade: %s%n",
                      NumberFormat.getInstance().format(score),
                      gradeMap.floorEntry(score).getValue());
}