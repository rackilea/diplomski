else if (month == 2 && year % 4 == 0 && year != 1900)
    dayLimit = 29;

// February not leap year
else if (month == 2)
    dayLimit = 28;