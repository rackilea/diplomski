public class StringTest 
{

    public static final String crT = "CREATE TABLE ";
    public static final String inI = "INSERT INTO ";
    public static final String val = " VALUES ";

    public static final String[] catInsertArray = new String[13];

    // you were probably doing this, which is not allowed in Java because you are writing code outside of a method body or static initializer block
    //catInsertArray[0] = inI + val + "(null, 'Student Loan', 'in', 0.00, 0.00, 0.00, 0, 0 );"; 

    static
    {
         // static initialize your static member
         catInsertArray[0] = inI + val + "(null, 'Student Loan', 'in', 0.00, 0.00, 0.00, 0, 0 );"; 
    }

    public static void main(String [] args)
    {
        // You can put code in a method
        //catInsertArray[0] = inI + val + "(null, 'Student Loan', 'in', 0.00, 0.00, 0.00, 0, 0 );"; 

    }
}