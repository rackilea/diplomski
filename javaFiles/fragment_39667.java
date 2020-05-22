/**
 * Improved version
 */
public static Student getRandomStudentInstance() {

    // Generate an age between 18 and 40
    int age = studentRandomGenerator.nextInt(23) + 18;

    // Generate a name from the array:
    String name = namesForRandomStudents[studentRandomGenerator.nextInt(namesForRandomStudents.length)];

    // Generate a start year between 2000 and 2015 inclusive
    int startYear = studentRandomGenerator.nextInt(16) + 2000;

    // Generate student's current year between 1 and 4 inclusive
    int currentYear = studentRandomGenerator.nextInt(4) + 1;

    return new Student(age,name,startYear,currentYear);
}