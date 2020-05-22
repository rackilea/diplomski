//instance variable
private HashMap<String, List[]> qualifiedStudents;
    qualifiedStudents = new HashMap<String, List<String>>();

public String putStudentLastInRosters(String studentName) {
    for(String course : qualifiedStudents.keySet()) {
        List<String> students = qualifiedStudents.get(course);
        if(students.remove(studentName)) {
            students.add(studentName);
        }
    }
}