public class TestWeekend {
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;
    private static final Integer WEEKEND_START_FRIDAY_CUT_OFF_HOUR = 22;
    private static final Integer WEEKEND_END_SUNDAY_CUT_OFF_HOUR = 23;
    private static List<Integer> weekendDaysList = Arrays.asList(FRIDAY, SATURDAY, SUNDAY);

    public static void main(String []args) throws FileNotFoundException {
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,22,18,39)));
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,22,21,59)));
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,22,22,0)));
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,23,5,0)));
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,24,8,0)));
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,24,22,59)));
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,24,23,0)));
        System.out.println(" is weekend - "+isWeekend(LocalDateTime.of(2016,4,25,11,5)));
    }

    public static  boolean isWeekend(LocalDateTime dateTime) {
        System.out.print("Date - "+dateTime+" , ");
        if(weekendDaysList.contains(dateTime.getDayOfWeek().getValue()) ){
            if(SATURDAY ==  dateTime.getDayOfWeek().getValue()){
                return true;
            }
            if(FRIDAY == dateTime.getDayOfWeek().getValue() && dateTime.getHour() >=WEEKEND_START_FRIDAY_CUT_OFF_HOUR){
               return true;
            }else if(SUNDAY == dateTime.getDayOfWeek().getValue() && dateTime.getHour()  < WEEKEND_END_SUNDAY_CUT_OFF_HOUR ){
                return   true;
            }
        }
        //Checks if dateTime falls in between Friday's 22:00 GMT and Sunday's 23:00 GMT
         return false;
    }

 }