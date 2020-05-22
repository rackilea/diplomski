import java.util.ArrayList;
    public class Partition
    {
        static ArrayList<String> list = new ArrayList<String>();
        static int[][] partitions;

        public static void partition(int n)
        {
            partition(n, n, "");
            partitions = new int[list.size()][0];
            for (int i = 0; i < list.size(); i++)
            {
                String s = list.get(i);
                String[] stringAsArray = s.trim().split(" ");
                int[] intArray = new int[stringAsArray.length];
                for (int j = 0; j < stringAsArray.length; j++)
                {
                    intArray[j] = Integer.parseInt(stringAsArray[j]);
                }
                partitions[i] = intArray;
            }
        }

        public static void partition(int n, int max, String prefix)
        {
            if(prefix.trim().split(" ").length > 8 || (prefix + " ").contains(" 2 "))
            {
                return;
            }
            if (n == 0)
            {
                list.add(prefix);
                return;
            }

            for (int i = Math.min(max, n); i >= 1; i--)
            {
                partition(n - i, i, prefix + " " + i);
            }
        }

        public static void main(String[] args)
        {
            int N = 50;
            partition(N);

            /**
             * Demonstrates that the above code works as intended.
             */
            for (int i = 0; i < partitions.length; i++)
            {
                int[] currentArray = partitions[i];
                for (int j = 0; j < currentArray.length; j++)
                {
                    System.out.print(currentArray[j] + " ");
                }
                System.out.println();
            }
        }
    }