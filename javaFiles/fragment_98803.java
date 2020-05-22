final long MILLIS_PER_DAY = 1000*60*60*24;
long time1 = 1546258765000L; // (Mon 31 December 2018 13:19:25)
long time2 = 1546005915367L; // (Fri 28 December 2018 15:05:15)

// Set both times to 0:00:00
time1 -= time1 % MILLIS_PER_DAY;
time2 -= time2 % MILLIS_PER_DAY;