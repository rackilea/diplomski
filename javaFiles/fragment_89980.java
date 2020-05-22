class UndergradStudent extends Student {

    private int year;

    public UndergradStudent(int number, String name, double gpa, int year) {
        super(number, name, gpa);
        this.year = year;
    }

    public String toString() {
        return "Undergraduate: " + super.toString() + " year: " + year;
    }

    @Override
    public double getMinimumHonourListGPA() {
        return 3.5;
    }
}