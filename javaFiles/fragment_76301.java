public static void main(String[] args) {
      Calendar now = Calendar.getInstance();
      //now.setTime(new Date()); // set the date you want to calculate the days for
      Calendar tmp = Calendar.getInstance();
      tmp.set(0,0,0); // init a temporary calendar.
      int days=0;
      // iterate from 1900 and check how many days are in the year, sum the days 
      for (int i=1900; i < now.get(Calendar.YEAR);i++) {
          tmp.set(Calendar.YEAR, i);
          int daysForThatYear = tmp.getActualMaximum(Calendar.DAY_OF_YEAR);
          days+=daysForThatYear;
          System.out.printf("year:%4d days in the year:%3d, total days:%6d\n",i,daysForThatYear,days);
      }
      // check the number of days for the current year, and add to the total of days
      int daysThisYear = now.get(Calendar.DAY_OF_YEAR);
      days+=daysThisYear;
      System.out.printf("year:%4d days in the year:%3d, total days:%6d\n",now.get(Calendar.YEAR),daysThisYear,days);
}