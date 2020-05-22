import java.util.Scanner;

public final class A {

    private final int l;
    private final int d;
    private final int n;

    public A() {
        Scanner scanner = new Scanner(System.in);
        int[] list = this.getFirstLine(scanner);
        l = list[0];
        d = list[1];
        n = list[2];

        /* the rest of the constructor method */
    }

    private int[] getFirstLine(Scanner scanner) {
        return new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
    }
}