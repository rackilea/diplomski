public static void withdrawStudent(String student) {
    for (Set<String> studentSet : enrollments.values()) {
        studentSet.remove(student);

    }
}