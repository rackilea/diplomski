public class KthLargestElementTest
{
    public static void main (String[] args) throws java.lang.Exception
    {
        testDistinct();
        testNonDistinct();
        testAllEqual();
    }

    private static void testDistinct()
    {
        System.out.println("testDistinct");
        int[][] input = new int[][] 
        {
            {1, 2, 3, 4},
            {8, 9, 10, 11},
            {33, 44, 55, 66},
            {99, 150, 170, 200}
        };
        for (int i = 1; i <= 17; i ++) 
        {
            System.out.println(findkthLargestElement(input, i, 4, 4));  
        }
    }

    private static void testNonDistinct()
    {
        System.out.println("testNonDistinct");
        int[][] input = new int[][]
        {
            { 1, 1, 1, 4 },
            { 4, 4, 11, 11 },
            { 11, 11, 66, 66 },
            { 66, 150, 150, 150 } 
        };
        for (int i = 1; i <= 6; i++)
        {
            System.out.println(findkthLargestElement(input, i, 4, 4));
        }
    }    

    private static void testAllEqual()
    {
        System.out.println("testAllEqual");
        int[][] input = new int[][]
        {
            { 4, 4, 4, 4 },
            { 4, 4, 4, 4 },
            { 4, 4, 4, 4 },
            { 4, 4, 4, 4 } 
        };
        for (int i = 1; i <= 2; i++)
        {
            System.out.println(findkthLargestElement(input, i, 4, 4));
        }
    }    

    public static int findkthLargestElement(
        int[][] input, int k, int m, int n) 
    {
        int counter = 0;
        int i=m*n-1;
        int previousValue = Integer.MAX_VALUE;
        while (i >= 0)
        {
            int value = input[i/n][i%n];
            if (value < previousValue)
            {
                counter++;
            }
            if (counter == k)
            {
                return value;
            }
            previousValue = value;
            i--;
        }
        if (counter == k)
        {
            return input[0][0];
        }
        System.out.println("There are no "+k+" different values!");
        return Integer.MAX_VALUE;
    }

}