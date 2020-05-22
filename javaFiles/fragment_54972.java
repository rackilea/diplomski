import java.lang.Math;
import java.lang.StringBuilder;

public class random24 {
    static char digits[] = {'0','1','2','3','4','5','6','7','8','9'};

    public static char randomDecimalDigit() {
        return digits[(int)Math.floor(Math.random() * 10)];
    }

    public static String randomDecimalString(int ndigits) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<ndigits; i++) {
            result.append(randomDecimalDigit());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(randomDecimalString(24));
    }
}