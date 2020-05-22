public class gregorianCalendar {
    public static void main(String[] args){
        Calendar cal = new GregorianCalendar();
        // --------------- Current Date ------------
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int weekday = cal.get(Calendar.DAY_OF_WEEK);
        System.out.print("today, the date is: " + month);
        System.out.print("/" + dayOfMonth);
        System.out.println("/" + year);    


        // ---------- Current date + 100------------
        cal.add(Calendar.DAY_OF_MONTH, 100);
        System.out.print("100 days from today, the date will be: " + cal.get(Calendar.MONTH));
        System.out.print("/" + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("/" + cal.get(Calendar.YEAR));
    }
}