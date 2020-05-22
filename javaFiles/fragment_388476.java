public class Group {

    private List<Student> group;

    public void setStudents(List<Student> students) {
        this.group = students;
    }

    public List<Student> getStudents() {
        return group;
    }

    @Override
    public String toString() {
        return "Group [group=" + group + "]";
    }
}