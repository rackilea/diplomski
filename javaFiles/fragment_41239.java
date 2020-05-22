catch(InputMismatchException notAValidInt)
{
    scan.reset();
    System.out.println("Not valid - must be a number greater than 0 "); 
    //position is still 0
    scan.next(); //position is now 1
}