public static boolean isLegitimate(int mon, int day, int year){

    // February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.

    // TODO 1: Check if a date is valid.

    //checks to see if the months are between 1 and 12
    if(mon<1) return false;
    if(mon>12) return false;

    //checks to see if the years are greater than 1
    if(year<=0) return false;

    //checks to see if the days are between 1 and 31
    if(day<=0) return false;
    if(day>31) return false;

    //This checks that if the month is February, is divisible by 4 evenly,
    //and is divisible by 100 evenly, then the days can not exceed 29
    if ((mon == 2) && (year%4==0) && (!(year%100==0)) || (year%400==0)){
        if (day >29){
            return false;
        }
    }
    return true;
}