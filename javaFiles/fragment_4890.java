// Here, we are checking to see what the output of the random was
switch(number) { 
    case 1:
        // E.g., if the output is 1, the activity we will open is ActivityOne.class
        activity = ActivityOne.class;
        break;
    case 2:
        activity = ActivityTwo.class;
        break;
    case 3:
        activity = ActivityThree.class;
        break;
    case 4:
        activity = ActivityFour.class;
        break;
    default:
        activity = ActivityFive.class;
        break;
}