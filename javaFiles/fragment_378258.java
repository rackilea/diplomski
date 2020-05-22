public class CalendarUtil{
    private static String lastUsedDatePrefix = "";
    private static int counter = 0;

    public String getRemId(){
        final String datePrefix = new SimpleDateFormat("ddMMyyy").format(new Date());
        if (lastUsedDatePrefix.equals(datePrefix)) {
            CalendarUtil.counter++;
        }
        else{
            CalendarUtil.lastUsedDatePrefix = datePrefix;
            CalendarUtil.counter = 0;
        }
        final String counterSuffix = ((100 <= CalendarUtil.counter) ? ""
                : (10 <= CalendarUtil.counter) ? "0" : "00")
                + CalendarUtil.counter;
        return datePrefix + counterSuffix;
     }   
}