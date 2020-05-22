long offset = 19800; //offset IST (seconds)
  long time = TimeUnit.SECONDS.toMinutes(offset); //or offset/60
  long hour = time / 60;
  long min = Math.abs(time % 60);
  String hrStr = "";
  if (hour > 0 && hour < 10) {
    hrStr = "+0" + String.valueOf(hour);
  } else if (hour >= 10) {
    hrStr = "+" + String.valueOf(hour);
  } else if (hour < 0 && hour > -10) {
    hrStr = "-0" + String.valueOf(hour).substring(1);
  } else {
    hrStr = String.valueOf(hour);
  }
  String minStr = String.valueOf(min);
  if (min < 10) {
    minStr = "0" + (time % 60);
  }
  String timeStr = hrStr + ":" + minStr;
  System.out.println(timeStr);