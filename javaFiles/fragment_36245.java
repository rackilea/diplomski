import java.util.Arrays;

public class Product {

    // auxiliary method
    private static void _arrayProd(int[] v1, int[] v2, int[] result, int n, int i) {
        if(i < n){
            result[i] = v1[i] * v2[i];
             _arrayProd(v1, v2, result, n, i+1);
        }
    }

    public static int[] arrayProd(int[] v1, int[] v2, int n) {
        int[] result = null;
        if(n >= 0){
            result = new int[n];
            _arrayProd(v1, v2, result, n, 0);
        }
        return result;
    }


    public static void main(String [] args) {
        int[] v1 = {1, 2, 3, 4, 5};
        int[] v2 = {2, 4, 6, 8};
        int n = 3;

        int[] v3 = arrayProd(v1, v2, n);

        System.out.println(Arrays.toString(v3));
    }
}