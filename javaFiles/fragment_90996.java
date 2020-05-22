while (scan.hasNextInt() && positive == false)
{
    int input = scan.nextInt();
    if (input > 0)
    {
        positive = true;
        {
            return input;
        }
    }
    else
    {
        System.out.println ("Bad input enter an integer.");
        positive = false;
        scan.nextLine();
    }
}