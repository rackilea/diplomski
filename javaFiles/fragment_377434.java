public class RegTest {
    public static final void main(String[] args) {
        String regex, test, result;

        // First, test without the negation and make sure it *does* replace the target chars
        regex = "[0-9a-zA-Z/\\-?:().,'+ ]+";
        test = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/-?:().,'+";
        result = test.replaceAll(regex, "%");
        System.out.println(result);
        // Prints %

        // Now, test *with* the negation and make sure it matches other characters (I put
        // a few at the beginning) but not those
        regex = "[^0-9a-zA-Z/\\-?:().,'+ ]+";
        test = "[@!\"~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/-?:().,'+";
        result = test.replaceAll(regex, "%");
        System.out.println(result);
        // Prints %abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/-?:().,'+
    }
}