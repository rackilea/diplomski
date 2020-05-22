public class CombSort
{
    private static final int PROBLEM_SIZE = 5;
    static int[] in = new int[PROBLEM_SIZE];

    public static void printArr()
    {
        for(int i=0;i<in.length;i++)
        {
            System.out.print(in[i] + "\t");
        }
        System.out.println();
    }

    public static void combSort()
    {
        int swap, i, gap=PROBLEM_SIZE;
        boolean swapped = false;
        printArr();
        while ((gap > 1) || swapped) 
        {
            if (gap > 1) 
            {
                gap = (int)( gap / 1.247330950103979);
            }

            swapped = false;

            for (i = 0; gap + i < PROBLEM_SIZE; ++i) 
            {
                if (in[i] - in[i + gap] > 0) 
                {
                    swap = in[i];
                    in[i] = in[i + gap];
                    in[i + gap] = swap;
                    swapped = true;
                }
            }
        }
        printArr();
    }

    public static void main(String[] args)
    {
        for(int i=0;i<in.length;i++)
        {
            in[i] = (int) (Math.random()*PROBLEM_SIZE);
        }
        combSort(); 
    }

}