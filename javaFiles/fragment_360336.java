class Student {
...
private static final Comparator<Student> STU_COMP = new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getStudentNo().compareTo(s2.getStudentNo());
    }
};
...
}