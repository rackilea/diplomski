abstract class Student {

    private int number;
    private String name;
    private double gpa;

    public Student(int number, String name, double gpa) {
        this.number = number;
        this.name = name;
        this.gpa = gpa;
    }

    public double getGPA() {
        return gpa;
    }

    public abstract double getMinimumHonourListGPA();

    public boolean deansHonourList() {
        boolean result = false;
        if (getGPA() >= getMinimumHonourListGPA()) {
            result = true;
        }
        return result;
    }

    public String toString() {
        return number + " " + name + " (" + gpa + ")";
    }
}