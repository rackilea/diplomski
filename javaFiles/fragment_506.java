public void printTimeZoneDifference(String from, String to) {
   TimeZone easternStandardTime = TimeZone.getTimeZone(from);
   TimeZone indiaStandardTime = TimeZone.getTimeZone(to);

   long milliseconds = easternStandardTime.getRawOffset() - indiaStandardTime.getRawOffset() + easternStandardTime.getDSTSavings() - indiaStandardTime.getDSTSavings();
   String difference = String.format("%02d min, %02d sec", TimeUnit.MILLISECONDS.toMinutes(milliseconds), TimeUnit.MILLISECONDS.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));

   System.out.println("The difference in time between" + easternStandardTime.getDisplayName() + " and " + indiaStandardTime.getDisplayName() + " is " + difference);
 }