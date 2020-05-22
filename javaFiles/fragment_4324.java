import java.io.InputStream;

class Main {
    public static void main(String[] args) {
        long result = 0;
        long modulo = 10000000000L;

        for (int i = 1; i <= 1000; i++) {
            long temp = i;
            for (int j = 1; j < i; j++) {
                temp *= i;
                temp %= modulo;
            }

            result += temp;
            result %= modulo;
        }
        System.out.println(result);
    }