public class IntBubbleSorter {

    public static int count = 0;

    public static int count2 = 0;

    public static void bubbleSort(int[] array)
    {
        int lastPos;
        int index;
        int temp;
        count = 0;
        count2 = 0;

        for (lastPos = array.length - 1; lastPos >= 0; lastPos--)
          {
            for (index = 0; index <= lastPos - 1; index++)
            {
                count2++;

                if (array[index] > array[index + 1])
                {
                    count++;
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
          }
    }
}


public class SortingTest {

    public static void main(String[] args) 
    {
        int[] values = { 1,53,86,21,49,32,90,65,33,11,34,68,54,32,78,80,35,22,96,59,265,44324,123,3123,25435};

        System.out.println("Original Order: ");
        for (int element : values) 
            System.out.print(element + " ");

        IntBubbleSorter.bubbleSort(values);

        System.out.println("\nSorted order: ");
        for (int element : values) 
            System.out.print(element + " ");

        System.out.println();

        System.out.print("\n Swaps:" + IntBubbleSorter.count);

        System.out.print("\n Comparisons:" + IntBubbleSorter.count2);
    }
}