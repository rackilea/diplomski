Calendar to = (Calendar) start.clone();

    int temp = Functions.weekdays(start.getTime(), days);
    temp = temp - (2 * temp);

    start.add(start.DAY_OF_MONTH, temp);