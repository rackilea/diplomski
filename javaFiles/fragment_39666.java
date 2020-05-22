/**
 * NAIVE APPROACH, NOT RECOMMENDED
 */
public static Student getRandomStudentInstance() {

    boolean failed = true;
    Student result = null;
    do {
        try {
            result = new Student(
                            studentRandomGenerator.nextInt(),
                            namesForRandomStudents[studentRandomGenerator.nextInt(namesForRandomStudents.length)],
                            studentRandomGenerator.nextInt(),
                            studentRandomGenerator.nextInt());
            failed = false;
        } catch ( IllegalArgumentException e ) {
            // Nothing to do here, failed will be true so
            // we'll attempt to generate again
        }
    } while ( failed );

    return result;
}