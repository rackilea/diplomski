if(currentYear > dataYear) {
    //We're obviously past that date. Move on
} else if(currentYear == dataYear) {
    //We're in the same year. Let's check for months
    if(currentMonth > dataMonth) {
        //Missed the date again, move on
    } else if(currentMonth == dataMonth) {
        //We're in the same year and the same month! Let's check days
        if(currentDay > dataDay) {
            //Date is still in the past. Keep moving on
        } else if(currentDay == dataDay) {
            //Date is today
        } else {
            //Date is in the future
        }
    }
} else {
    //Date is in the past
}