boolean isMonsoon;

switch (month) {
    case 7:
    case 8:
    case 9:
        isMonsoon = true;
        break;

    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 10:
    case 11:
    case 12:
        isMonsoon = false;
        break;

    case 6:
        // use if else statement so user knows that before june 15 is not monsoon season
        if (day >= 15)
            isMonsoon = true;
        else
            isMonsoon = false;
        break;

    default:
        System.out.println("not valid");
        break;
}

if (isMonsoon)
    System.out.println("is monsoon season");
else
    System.out.println("is NOT monsoon season");