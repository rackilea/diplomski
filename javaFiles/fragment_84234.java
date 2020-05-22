if (Year.matches(FULL_YEAR))
    {
        System.out.println("The year is " + Year);
    }
    else if (Year.matches(TWO_YEAR))
    {
        System.out.println("The year is " + 2000 + Year);
    }
    else
    {
        System.out.println("Invalid Year");
    }