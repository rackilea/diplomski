public class Test {
    public static void main(String[] args) {
        SimpleDateFormat formatDayOfMonth = new SimpleDateFormat("d");
        String s = formatDayOfMonth.format(new Date());
        System.out.println(s);
        int num=Integer.parseInt(s);
        System.out.println(get(num));

    }

    private static String get(int num){
        String[] suffix = {"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        int m = num % 100;
       return String.valueOf(num) + suffix[(m > 10 && m < 20) ? 0 : (m % 10)];
    }
}