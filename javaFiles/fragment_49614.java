System.out.print("Enter # of test cases: ");

int t = scan.nextInt();
scan.nextLine();

if (t >= 1 && t<= 100)
{
    System.out.println("Enter values:");

    for (int j = 0; j < t; j++)
    {
        String input = scan.nextLine();