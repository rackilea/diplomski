while(true)
{
    try
    {
      System.out.println("Enter your name");
            Name = in.next();
            break;
    }
    catch (InputMismatchException exception) {
            System.out.println("Enter valid input");

    }
    in.next();
    continue;
}