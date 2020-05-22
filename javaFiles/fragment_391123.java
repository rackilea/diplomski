while (Day != 18 || Month != 2)
{
    System.out.print ("Enter the Month: ");
    Month = scan.nextInt();
    System.out.print ("Enter the Day: ");
    Day = scan.nextInt();

    if (Month == 2 && Day == 18)
        System.out.println ("Nice! You got the Special Day!");
    else if ((Month > 2) || (Month == 2 && Day > 18))
        System.out.println ("That's after the Special Day, try again!");
    else if ((Month < 2) || (Month == 2 && Day < 18))
        System.out.println ("That's before the Special Day, try again!");
}