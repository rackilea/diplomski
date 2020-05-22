import java.util.*;

public class Main
{
    static int[] basket(int n)
    {
        int[] p = new int[++n];

        while (n-- > 0) p[n] = 1;
        return p;
    }

    static int[] mult(int[] p, int[] q)
    {
        int[] r = new int[p.length + q.length - 1];

        for (int i = 0; i < p.length; ++i) {
            for(int j = 0; j < q.length; ++j) {
                r[i + j] += p[i] * q[j];
            } 
        }

        return r;
    }

    public static void main(String[] args)
    {
        int[] res = basket(0);

        res = mult(res, basket(2));
        res = mult(res, basket(3));
        res = mult(res, basket(2));

        System.out.println(res[5]);
    }
}