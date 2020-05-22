public class StudentImplementation {

    public static void main(String[] args) {
        Student first = new Student(); //default constructor
        System.out.println(first.getCourseGrade());
        Student second = new Student(3, "Advanced JAVA Programming", 83);
        System.out.println(second.getCourseGrade());
    }

}