public class TestDate01 {

    public static final String OLD_FORMAT = "yyyy-MM-dd";
    public static final String NEW_FORMAT = "yyyy-MMM-dd";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String oldValue = "2013-05-29";
            Date date = new SimpleDateFormat(OLD_FORMAT).parse(oldValue);
            String newValue = new SimpleDateFormat(NEW_FORMAT).format(date);
            System.out.println("oldValue = " + oldValue + "; date = " + date + "; newValue = " + newValue);
        } catch (ParseException exp) {
            exp.printStackTrace();
        }
    }
}