public class MyCustomProperty { 
    // can't change this in application.properties
    private final String lowerCase;
    // can change this in application.properties
    private String atitude;
    private long someNumber;

    public MyCustomProperty (String lowerCase, String atitude, long someNumber) {
        this.lowerCase = lowerCase;
        this.atitude = atitude;
        this.someNumber = someNumber;
    }
    // getter and Setters
}