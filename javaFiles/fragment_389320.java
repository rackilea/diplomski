public class ZigZag {
    public static void main(String[] args) {
        int n = 4;

        zigZag(n, 0);
    }

    public static void zigZag(int n, int i /* indentation factor */) {
        if(n > 1)
            zigZag(n / 2, i);

        for(int k = i; k > 0; k--)
            System.out.print(" ");

        for(int k = n; k > 0; k--)
            System.out.print("*");

        System.out.println();

        if(n > 1)
            zigZag(n / 2, i + n / 2);
    }
}