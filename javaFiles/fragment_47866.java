public class Af {

    public Af() {
    }

    int sum1 = 0;

    public int a() {
        int nr = 7;
        int c = 4;
        sum1 = nr + c;
        return sum1;
    }

    public int b() {

        int l = 7;
        int m = 4;
        int sum2 = m + l;
        return sum2;

    }

    public int c() {
        int sum3 = 0;
        sum3 = a() + b();
        return sum3;
    }
}