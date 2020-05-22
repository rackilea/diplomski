// Declaration
public class SharedLocation {
    static public SomeObject someObject=new SomeObject(); // default object
    }

// Publishing code
// Note: do not simply use SharedLocation.someObject.xxx(), since although
//       someObject will be internally consistent for xxx(), a subsequent 
//       call to yyy() might be inconsistent with xxx() if the object was 
//       replaced in between calls.
SharedLocation.someObject=new SomeObject(...); // new object is published

// Using code
private String getError() {
    SomeObject myCopy=SharedLocation.someObject; // gets current copy
    ...
    int cod=myCopy.getErrorCode();
    String txt=myCopy.getErrorText();
    return (cod+" - "+txt);
    }
// And so on, with myCopy always in a consistent state within and across calls
// Eventually we will return to the code that gets the current SomeObject.