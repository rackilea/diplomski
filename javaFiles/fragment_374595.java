public Person submitData() {
    Person p = null;
    try {
       p = ...;
       checkForMissingFields( p );
       ...
    }
    catch ( MissingFieldException e) {
       // handle exception
    }
    return p;
}