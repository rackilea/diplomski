double price = 0;
switch (input)
    {
        case "2/15/13":
            price = 0.10;
            break;
        case "4/15/13":
            price = 0.12;
            break;
        case "8/15/13":
            price = 0.15;
            break;
        case "11/15/13":
            price = 0.15;
            break;
        default:
            System.out.println("Invalid date");
    }


    //Declaring variables for calculations
    double base = 0;
    double over = 0;
    double excess = 0;

    double math1 = 0;
    double math2 = 0;


    //KW Calculations
    if (kwUsed <= 350)
    {
        base = kwUsed * price;

    }else if (kwUsed <= 500)
    {
        math1 = ((kwUsed - 350) * price);
        base = ((kwUsed * price) - math1);
        over = ((math1 * 0.1) + math1);

    }...