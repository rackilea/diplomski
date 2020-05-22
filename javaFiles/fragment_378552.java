class Name
{
    String firstName;
    String lastName;

    Name(String first, String last)
    {
        firstName = first;
        lastName = last;
    }

    public String toString() 
    {
        return "[firstName = " + firstName + ", lastName = " + lastName + "]";
    }
}