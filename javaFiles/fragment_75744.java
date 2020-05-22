//Removed import because you aren't using it

public class NewClass {

  public static void main(String[] args)
  {                 
    System.out.println("kilograms | pounds");
    System.out.println("--------+-----------");
    for (int i = 1; i <= 199; i ++) 
    // define i at this point because it's only used in this scope
    {            
      System.out.println("| " + i + " | " + (2.2 * i) + " |");
      // Use normal "
      // you misspelled println
      // put parenthesis around calculations
    }
    System.out.println("");
  } //end method
} // end class