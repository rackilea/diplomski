import java.util.Random;

public class Example {

    static char randomChar (Random r, String cs, boolean uppercase) {
        char c = cs.charAt(r.nextInt(cs.length()));
        return uppercase ? Character.toUpperCase(c) : c;
    }

    static String mask (String str, int seed) {

        final String cons = "bcdfghjklmnpqrstvwxz";
        final String vowel = "aeiouy";
        final String digit = "0123456789";

        Random r = new Random(seed);
        char data[] = str.toCharArray();

        for (int n = 0; n < data.length; ++ n) {
            char ln = Character.toLowerCase(data[n]);
            if (cons.indexOf(ln) >= 0)
                data[n] = randomChar(r, cons, ln != data[n]);
            else if (vowel.indexOf(ln) >= 0)
                data[n] = randomChar(r, vowel, ln != data[n]);
            else if (digit.indexOf(ln) >= 0)
                data[n] = randomChar(r, digit, ln != data[n]);
        }

        return new String(data);

    }

    public static void main (String[] args) {

        System.out.println(mask("John Doe, 534 West Street, Wherever, XY. (888) 535-3593. 399-35-3535", 0));

    }
}