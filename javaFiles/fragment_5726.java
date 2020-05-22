public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int hourStart = 5;
        int minuteStart = 30;
        String PMAMStart="AM";
        int hourEnd = 6;
        int minuteEnd = 30;
        String PMAMEnd="AM";

        boolean checkTime=  checkCurrentTimeBetweenTwoValues(hourStart,minuteStart,PMAMStart,hourEnd,minuteEnd,PMAMEnd);

        if (checkTime) {
            System.out.println("Time is Same");
        } else {
            System.out.println("Time is not Same");
        }

    }

    private boolean checkCurrentTimeBetweenTwoValues(int hStart,int mStart,String ampmStart,int hEnd,int mEnd,String ampmEnd){

      Calendar startCalendar = Calendar.getInstance();
      Calendar endCalendar = Calendar.getInstance();

      if (ampmStart.equalsIgnoreCase("AM")) {
          startCalendar.set(Calendar.AM_PM, 0);
      } else {
          startCalendar.set(Calendar.AM_PM, 1);
      }

      startCalendar.setTimeZone(TimeZone.getDefault());
      startCalendar.set(Calendar.HOUR, hStart);
      startCalendar.set(Calendar.MINUTE, mStart);

      if (ampmEnd.equalsIgnoreCase("AM")) {
          endCalendar.set(Calendar.AM_PM, 0);
      } else {
          endCalendar.set(Calendar.AM_PM, 1);
      }

      endCalendar.setTimeZone(TimeZone.getDefault());
      endCalendar.set(Calendar.HOUR, hEnd);
      endCalendar.set(Calendar.MINUTE, mEnd);

      long timeDifference = TimeUnit.MILLISECONDS.toMinutes(
            Math.abs(endCalendar.getTimeInMillis() - startCalendar.getTimeInMillis()));
      System.out.println(("Time Difference: " + timeDifference));

      return (timeDifference == 0);
    }
}