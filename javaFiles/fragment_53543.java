Boolean check = true;

do
{
    try
    {
        //The code to read numbers
    }
    catch(InputMismatchException e)
    {
        System.err.println("Please enter a number!");
        check = false;
    }
}
while(check == false)