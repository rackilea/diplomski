public class Dd {

    public static void main(String args[]) throws ParseException {

        String s1 = "2014-01-15 00:003:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = sdf.parse(s1);
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String s3 = sdf1.format(date);
            System.out.println(s3);

        } catch (ParseException e) {
            System.out.println(e);
        }

    }
}