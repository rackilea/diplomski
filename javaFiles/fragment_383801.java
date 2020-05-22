public class Student implements Comparable<Student> {
    public int compareTo(Student s) {
        int result = studentUnion.compareTo(s.studentUnion);
        if (result != 0)
            return result;
        // use another field like name to break ties on StudentUnion
        return name.compareTo(name);
    }
}