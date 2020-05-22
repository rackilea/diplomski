public class test1 {
    int[] final23;

    public int[] sum(int[] x, int[] y) {
        final23 = new int[Math.min(x.length, y.length)];
        for (int i = 0; i < final23.length; i++) {
            final23[i] = x[i] + y[i];

        }
        return final23;
    }

    public void print() {
        for (int aFinal23 : final23) {
            System.out.println(aFinal23);
        }
    }


    public static void main(String[] args) {
        int l[] = {4, 7, 2};
        int k[] = {4, 6, 2};
        test1 x = new test1();

        x.sum(k, l);
        x.print();
    }
}