public void createUnits() {
    units[0] = new Unit("FIT1234", "Advance Bogosorts");
    units[0].studentList.add(new Student(1234, "Mark", "Stevens"));
    units[0].studentList.add(new Student(5678, "Steven", "Perry"));

    units[1] = new Unit("FIT2345", "Java Programming");
    units[1].studentList.add(new Student(9012, "Cooper", "Smith"));

    units[2] = new Unit("FIT3456"," Java Fundamentals");
}