public class Human {
    private int age;
    private String name;

    /**
     * This is a constructor
     * @param ageIn
     * @param nameIn
     */
    public Human(int ageIn, String nameIn){
        if ( ageIn < 0 ) {
            throw new IllegalArgumentException( "Negative age is not acceptable for human: " + ageIn );
        }
        if ( ageIn > 150 ) {
            throw new IllegalArgumentException( "Age is limited to 150 years for a human, supplied value was: " + ageIn );
        }
        if ( nameIn == null ) {
            throw new IllegalArgumentException( "A non-null string is expected for human" );
        }
        age = ageIn;
        name = nameIn;
    }

    // Getters, setters
}