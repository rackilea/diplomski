Comparable n1 = new WierdNonNumberExtendingInteger(432);
    Comparable n2 = new WierdNonNumberExtendingLong(40);
    Comparable n3 = new WierdNonNumberExtendingDouble(500.12);

    Integer b =  null;
    if (n1.getClass().isInstance(n2))
    {
       b =  n1.compareTo(n2);
    }
    else
    {
       System.err.println("Can't compare apples and oranges");
       System.err.print("You tried to compare " + n1.getClass().getSimpleName());
       System.err.print(" with " + n2.getClass().getSimpleName());
    }

    System.out.println(b);