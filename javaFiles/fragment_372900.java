public class CustomeConverterUtils extends ConverterUtil {

     public static String convertToString(Calendar value) {
                if (value.get(Calendar.ZONE_OFFSET) == -1){
                    value.setTimeZone(TimeZone.getDefault());
                }
                StringBuffer dateString = new StringBuffer(28);
                appendDate(dateString, value);
                dateString.append("T");
                //adding hours
                appendTime(value, dateString);

                return dateString.toString();
        }

        public static void appendTime(Calendar value, StringBuffer dateString) {
            if (value.get(Calendar.HOUR_OF_DAY) < 10) {
                dateString.append("0");
            }
            dateString.append(value.get(Calendar.HOUR_OF_DAY)).append(":");
            if (value.get(Calendar.MINUTE) < 10) {
                dateString.append("0");
            }
            dateString.append(value.get(Calendar.MINUTE)).append(":");
            if (value.get(Calendar.SECOND) < 10) {
                dateString.append("0");
            }
           dateString.append(value.get(Calendar.SECOND));
        }
}