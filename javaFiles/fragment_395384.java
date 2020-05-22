import java.util.Arrays;

public class Foo {

    public double[][] method() {
        double[][] data = { {1.1, 1.2, 1.3},
                            {2.1, 2.2, 2.3} };

        return data;
    }

    public double[] getArray() {
    double[] data = {9.9,8.8,7.7};
    return data;
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        System.out.println(Arrays.toString(foo.method()));
    }
}