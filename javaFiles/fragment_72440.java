Calendar calendar = Calendar.getInstance();
    int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
    int daysLeft = lastDay - currentDay;


    System.out.println("Last Day: " + lastDay);
    System.out.println("Current Day : " + currentDay);
    System.out.println("There are " + daysLeft + " days left in the month.");