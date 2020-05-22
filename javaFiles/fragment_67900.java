public class Test0030 {

    public static void main(String[] args) {
        System.out.println(check_base("1.017.0", "8"));
        System.out.println(check_base("1.017.0", "7"));
        System.out.println(check_base("1.01F.0", "16"));
        System.out.println(check_base("1.01F.0", "15"));
    }

    private static String values = "0123456789ABCDEFG";

    private static boolean check_base(String number, String base) {
        StringBuilder no = new StringBuilder(number);
        while (no.length() != 0) {
            if (no.charAt(no.length() - 1) != '.' 
                    && 
                    values.indexOf(no.charAt(no.length() - 1)) >=
                    values.indexOf(values.charAt(Integer.parseInt(base)))) {
                return false;
            }
            no.deleteCharAt(no.length() - 1);
        }
        return true;
    }
}