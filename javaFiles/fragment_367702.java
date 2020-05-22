while (true)
    {
        Scanner reader = new Scanner(System.in);
        try
        {
            System.out.print("Enter an Short: "); //SHORT
            short myShort = reader.nextShort();
            System.out.println(myShort);
            reader.close();
            break;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error Try again.");
        }

    }