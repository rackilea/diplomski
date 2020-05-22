long differenceMinutes = (end.getTime() - start.getTime()) / 1000 / 60;
long differenceHours = differenceMinutes / 60;
// discount the number of hours
differenceMinutes -= (differenceHours * 60);
// seconds is always zero, because I'm not considering in the input
String differenceToString = "Hours: " + differenceHours + " Minutes: " + differenceMinutes + " Seconds: 0";