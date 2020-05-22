public class SERIES {
    // s and res are accessible in everywhere in SERIES class.
    int s = 0;
    int res = 1;

    int factorial(int n) {
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }

    int sum1(int n) {
        for (int i = 1; i <= n; i++)
            s += i;
        return s;
    }

    double sum2(int n) {
        double ts = 0.0;
        for (int i = 1; i <= n; i++) {
            ts = s / res;
        }
        return ts;
    }

    void main(int a) {
        double d = sum2(a);   // change to double
        System.out.println(d);
    }

}