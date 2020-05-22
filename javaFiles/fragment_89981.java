class Student {

    private int number;
    private String name;
    private double gpa;
    private double minimumHonourListGPA;

    public Student(int number, String name, double gpa, double minimumHonourListGPA) {
        this.number = number;
        this.name = name;
        this.gpa = gpa;
        this.minimumHonourListGPA;
    }

    public double getGPA() {
        return gpa;
    }

    public boolean deansHonourList() {
        boolean result = false;
        if (getGPA() >= minimumHonourListGPA) {
            result = true;
        }
        return result;
    }

    public String toString() {
        return number + " " + name + " (" + gpa + ")";
    }
}

class UndergradStudent extends Student {

    private int year;

    public UndergradStudent(int number, String name, double gpa, int year) {
        super(number, name, gpa, 3.5);
        this.year = year;
    }

    public String toString() {
        return "Undergraduate: " + super.toString() + " year: " + year;
    }
}