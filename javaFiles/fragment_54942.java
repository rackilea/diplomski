public class Test {

    public static void main(String[] args) throws ParseException {
        java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
                .parse("2012-07-10 14:58:00.000000");
        System.out.println(temp);
    }
}