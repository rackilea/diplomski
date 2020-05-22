import java.util.Random;

public class MarkovChainTest {
    private static char[] array = {'a', 'b', 'c', 'd'};
    private static double[] array2 = {.1, .3, .4, .2};

    public static void main(String[] args) {
        System.out.println(generateString(array, normalizeToOne(array2), 140));
    }

    private static double[] normalizeToOne(double[] freqs) {
        double sum = 0;
        for (double freq : freqs)
            sum += freq;
        double[] ret = new double[freqs.length];
        for (int i = 0; i < freqs.length; i++)
            ret[i] = freqs[i] / sum;
        return ret;
    }

    private static String generateString(char[] chars, double[] freqs, int length) {
        return generateString(chars, freqs, length, new Random(System.currentTimeMillis()));
    }

    private static String generateString(char[] chars, double[] freqs, int length, Random rnd) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++)
            ret.append(generateChar(chars, freqs, rnd));
        return ret.toString();
    }

    private static char generateChar(char[] chars, double[] freqs, Random rnd) {
        double val = rnd.nextDouble();
        double sumOfPrevFreqs = 0;
        for (int i = 0; i < chars.length; i++) {
            if (sumOfPrevFreqs + freqs[i] >= val)
                return chars[i];
            sumOfPrevFreqs += freqs[i];
        }
        throw new IllegalStateException("Sum of frequencies (" + sumOfPrevFreqs + ") < " + val);
    }
}