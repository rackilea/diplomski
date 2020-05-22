public class StudentsComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        final int nameComparison = s1.getName().compareToIgnoreCase(s2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(s1.getAge(), s2.getAge());
    }

}