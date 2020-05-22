public class Person {

    protected void check( String s, String msg ){
        if( s == null ||s.length < 1) {
            throw new InvalidDataException(msg);
        }
    }

    public Person(String firstname,String lastname) throws InvalidDataException{
        check( firstname, "Person's first name missing" );
        check( lastname, "Person's last name missing" );
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setFirstname( String firstname ){
        check( firstname, "Person's first name missing" );
        this.firstname = firstname;
    }
}