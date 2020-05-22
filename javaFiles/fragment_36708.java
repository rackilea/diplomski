public static void main(String[] args) throws ParseException {
    String from= "05:30:22";
    String to ="14:00:22";
    boolean fromIsAM = isAM(from);
    boolean toIsAM = isAM(to);
}
/**
 * Return true if the time is AM, false if it is PM
 * @param HHMMSS in format "HH:mm:ss"
 * @return
 * @throws ParseException
 */
public static boolean isAM(String HHMMSS) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date date = sdf.parse(HHMMSS);
    GregorianCalendar gc = new GregorianCalendar();
    gc.setTime(date);
    int AM_PM = gc.get(Calendar.AM_PM); 
    if (AM_PM==0) {
        return true;
    } else {
        return false;
    }

}