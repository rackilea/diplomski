int newCredits = ((int)credits/30) + 1
switch(newCredits)
    {
        case 1: //Below 30 credit
            System.out.println("Grade level code = " + freshmanC);
            break;
        case 2: //30 credits or more but less than 70 credits
            System.out.println("Grade level code = " + sophomoreC);
            break;
        case 3: //70 credits or more but less than 90 credits
            System.out.println("Grade level code = " + juniorC);
            break;
        default: //90 credits or more
            System.out.println("Grade level code = " + seniorC);
            break;
    }