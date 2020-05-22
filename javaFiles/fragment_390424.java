public class montecarlo {
public static void main(String[] args) {
        int [][] a = {{42, 12},{55, 21},{19,-2}};
        String[] x = openOrSenior(a);    //this would be line 20
        System.out.println(Arrays.asList(x));    //here was to see what i'd get if i let it run

    }

    static String[] openOrSenior(int[][] a) {
        int i, j, sum;
        String[] abo = new String[a.length];
        System.out.println(abo.length);
        for (i = 0; i < a.length; i++)
            for (j = 0; j < a[0].length; j++) {
                sum = 0;
                int x = a[i][j];
                sum = sum + x;
                if (sum > 62)
                    abo[i] = "Senior";
                else abo[i] = "Open";
            }   //this would be line 12
        return abo;
    }
}