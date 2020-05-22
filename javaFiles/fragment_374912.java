import java.util.*;

public class Distributor {

    private ArrayList<int[]> result =  new ArrayList <int[]> ();

    public Distributor (final String [] names, int [] low, int [] high) 
    {
        final int rest = 10;
        int minimum = 0;
        for (int l : low)
            minimum += l; 
        int [] sizes = new int [names.length];
        distribute (0, low, high, rest - minimum, sizes);
        System.out.println ("total size of results are " + result.size ());
        for (int [] ia : result)
            show (ia, low); 
    }

    public static void main (String [] args) {
        final String [] names = new String [] {"a", "b", "c"};
        int [] low = new int [] {2, 2, 1};
        int [] high = new int [] {3, 4, 6};
        new Distributor (names, low, high);
    }

    /*
        distribute the rest of values over the elements in sizes, beginning with index i.           
    */
    void distribute (int i, int [] low, int [] high, final int rest, int [] sizes) {
        // System.out.println (i + " " + rest + " " + sizes);
        if (i == sizes.length - 1) {
            if (rest < high [i]) {
                sizes[i] = rest; 
                result.add (Arrays.copyOf (sizes, sizes.length));
            }
        }
        else 
            for (int c = 0; 
                c <= java.lang.Math.min (high [i] - low [i], rest); 
                ++c) {  
                sizes [i] = c;
                    distribute (i + 1, low, high, rest - c, sizes);                 
            }
    }

    private static void show (int [] arr, int [] low) {      
        for (int x = 0; x < arr.length; x++) {
            System.out.print (" " + (arr [x] + low[x]));
        }
        System.out.println ();
    }
}