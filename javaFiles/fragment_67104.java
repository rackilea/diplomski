int days = longTimeInSeconds / (60 * 60 * 24);
int timeOfDay = longTimeInSeconds % (60 * 60 * 24);  // Leave converting this to hours/mins/secs to the student
int fourYearIntervals = days / (365 * 4 + 1);
int daysInInterval = days % (365 * 4 + 1);
int yearInInterval = daysInInterval / 365;
int daysInYear = daysInInterval % 365;  // For the student to convert to months/days
int year = fourYearIntervals * 4 + yearInInterval;