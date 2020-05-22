// This will work
double differenceMillis = currentMillis - oldMillis;
double differenceSeconds = differenceMillis / 1000;

// This will *not* work
double differenceSecondsBroken = (currentMillis - oldMillis) / 1000;