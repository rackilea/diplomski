private static void nextSunday(int day, int month, int year) {
    int febNum = isLeapYear(_year) ? 29 : 28;
    int dayCount = (month == 1) ? febNum : _months[_month]; //days in current month

    _day += 7;

    if (_day > dayCount) {  //new month
        _month++;
        _day -= dayCount;
    } 
    if (_month == 12) {    //new year
        _month = 0;
        _year++;
    }
}