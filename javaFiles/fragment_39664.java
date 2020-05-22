public class Student extends Human{
    private int startYear;
    private int currentYear;

    public Student( int age, String name, int startYear, int currentYear ) {

        super( age, name );
        if ( age < 18 ) {
            throw new IllegalArgumentException( "A student cannot be less than 18 years old. Supplied age is: " + age );
        }
        if ( startYear < 1980 || startYear > 2015 ) {
            throw new IllegalArgumentException( "A Student must have started studying between 1980 and 2015. Supplied start year is: " + startYear );
        }
        if ( currentYear < 1 || currentYear > 4 ) {
            throw new IllegalArgumentException( "A student must currently be in his 1st to 4th year. Supplied curret year is: " + currentYear );
        }
        this.startYear = startYear;
        this.currentYear = currentYear;
    }

    // Getters, setters, etc

}