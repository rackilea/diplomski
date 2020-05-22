//First: Change the base class exception to RuntimeException:
public class NoSuchElementException extends RuntimeException {
    public NoSuchElementException(String message){
        super(message);
    }
}

//Second: Remove the exception clause of the getId signature
//(and remove the unnecessary else structure):
public int getId(....) {
    if ( condition is met) { return variable; }
    //Exception will only be thrown if condition is not met:
    throw new NoSuchElementException (message);
}