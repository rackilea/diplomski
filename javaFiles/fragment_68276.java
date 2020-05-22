days = day
days += (month-1)*30;
days += (month)/2; // every odd month until July has 31 days
days += (month >= 8 && month % 2 == 1) ? 1 : 0;   // so if we have august or later and in an even month, add 1 day
if (month > 2) {
    days -= (isLeapYear(year)) ? 1 : 2;
}