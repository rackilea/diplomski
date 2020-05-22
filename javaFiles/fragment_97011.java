public static void main ( String[] args )
{
    Scanner input = new Scanner ( System.in );

    System.out.print ( "Enter four digit numbers: " );//prompt the user to enter numbers
    int n = input.nextInt();//read number entered by user

    // determine the 5 digits
    int Digit1;
    int Digit2;
    int Digit3;
    int Digit4;
    while(true)
    {
        if(n < 1000 || n > 9999)
        {
            System.out.println("Out of range, Sorry try again:");
            System.out.print ( "Enter four digit numbers: " );//prompt the user to enter numbers
            n = input.nextInt();//read number entered by user
        } else
        {
             Digit1 = n / 1000;
             Digit2 = n % 1000 / 100;
             Digit3 = n % 1000 % 100 / 10;
             Digit4 = n % 1000 % 100 % 10 / 1;
            break;
        }
    }


    System.out.println ( "The four digits integers are:" );

    System.out.printf ( "%d   %d   %d   %d\n%s\n", Digit1, Digit2, Digit3, Digit4, "Written by blabla" );

}