int totalTimeInMinutes = Hours.hoursBetween(d1 - d2).getHours;
int hour = 0;
int minute = 0;
if (totalTimeInMinutes < 0)
    totalTimeInMinutes *= -1;

hour = totalTimeInMinutes / 60;
minute = totalTimeInMinutes % 60;