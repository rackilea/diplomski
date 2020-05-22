double timeInDouble = 0.36712962962962964;

// The number of milliseconds since the beginning of the day
long milliseconds = (long) (timeInDouble * 24 * 60 * 60 * 1000);

Time time = new Time(milliseconds);