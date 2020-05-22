import java.util.ArrayList;
import java.util.Arrays;

public class Test011 {

    private static double[][] arr = new double[][]{
        {1.2, 1,  1},
        {4.3, 1 , 1},
        {2.0, 1 , 1},
        {2.9, 1 , 1},
        {6.2, 1 , 1},
        {2.5, 1 , 1}
    };

    private static double[][] filter(double[][] d, double num){
        ArrayList<double[]> lst = new ArrayList<double[]>();

        for (int i=0; i<d.length; i++){
            if (d[i][0] < num){
                lst.add(d[i]);
            }
        }
        double[][] result = new double[lst.size()][];
        return lst.toArray(result);
    }

    public static void main(String[] args) {
        double[][] a = filter(arr, 3.0);
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(a));
    }

}