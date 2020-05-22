public class Student {
    private String name = " ";
    public Student(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    Course course = new Course();

    public String toString() {
        return name;
    }

}