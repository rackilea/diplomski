char response = 0;
int numbers[] = new int[51];

do
{
    System.out.println("Enter in an integer between -25 and 25.");
    int n = SavitchIn.readLineInt();
    if( (n > 25) || (n < -25))
        System.out.println("Error, Invalid Input. Re-Enter integer between -25 and 25.");
    else
        numbers[n+25]++;

    System.out.println("Enter in another integer? (Y/N)");
    do
    {
        response = SavitchIn.readLineNonwhiteChar();
        if ( (Character.toLowerCase(response) != 'y') && (Character.toLowerCase(response) != 'n') )
            System.out.println("Incorrect Input. Must be 'Y' (yes) or 'N' (no).");
    } while ( (Character.toLowerCase(response) != 'y') && (Character.toLowerCase(response) != 'n') );
} while (Character.toLowerCase(response) == 'y');

for(int a = -25; a <= 25; a++)
    System.out.println(a + "'s entered: " + numbers[25+a] + " times\n");