int timeInSeconds = diff / 1000;
  int hours, minutes, seconds;
  hours = timeInSeconds / 3600;
  timeInSeconds = timeInSeconds - (hours * 3600);
  minutes = timeInSeconds / 60;
  timeInSeconds = timeInSeconds - (minutes * 60);
  seconds = timeInSeconds;