public static void main(String[ ] args)
 {
  final int[ ] DATA = { 2, 4, 6, 8, 10, 12, 14 };
  final int[ ] EMPTY = new int[0];
  final int MINIMUM = 0;
  final int MAXIMUM = 16;
  boolean foundElement;
  int target;

  System.out.println("Searching for numbers in an array.");
  for (target = MINIMUM; target <= MAXIMUM; target++)
  {
      System.out.print("\nIs " + target + " in the array? ");
      foundElement = false;
      for (int index = 0; (index < DATA.length && !foundElement); index++)
       {
             foundElement = (DATA[index] == target);
             if ( foundElement )
               System.out.printf("Yes! %d was found at index [%d]", target, index);                       
        }
        if (!foundElement)
          System.out.printf(" Not found");    
  }
}