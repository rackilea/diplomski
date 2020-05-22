//go through each time sheet
for(int i = 1; i <= numberOfTimesheets; i++){
    hoursWorked = 0; // reset the number of hours worked (presumably for that week).
    centsPerHour = stdin.nextInt(); //get the wage of the current timesheet

    //go through each day for the current timesheet
    for (int ii = 1; ii <= 5; ii++){
        hoursWorked = hoursWorked + stdin.nextInt(); //add up the number of hours worked in that week
    }
    total = total + (hoursWorked * centsPerHour); //add the amount of money made this week to their current total (salary).
}