class Student {
    String studentFirstName;
    String studentLastName;
    List<Course> studentSchedule; // no initialization here: it's done in the constructor

    // Constructors
    Student(String newFirstName,  String newLastName) {
        this(newFirstName, newLastName, new ArrayList<Course>());
    }

    Student(String newFirstName, String newLastName, List<Course> newSchedule) {
        this.studentFirstName = newFirstName;
        this.studentLastName = newLastName;
        this.studentSchedule = newSchedule;
    }