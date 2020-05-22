public class Student implements Comparable<Student> {

    /*
     * nearly the entire class stays untouched,
     * except from the class declaration and the additional method below
     */

    @Override
    public int compareTo(Student o) {
        return this.getAvg().compareTo(o.getAvg());
    }

    // you could and probably should implement equals(Student o) and hashCode() as well
}