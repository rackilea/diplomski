public class Main {

    public Main()
    {

    }

    public static void main(String[] args)
    {
        int array[] = {0, 4, 2, 8, 7, 9, 1, 6, 5, 3};
        Main m = new Main();
        int[][] cycles = m.getCycles(array);
        for (int i = 0; i < cycles.length; i++)
        {
            System.out.print("[");
            for (int j = 0; j < cycles[i].length; j++)
            {
                System.out.print(cycles[i][j]);
                if (j < cycles[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println("end debug");
    }

    public int[][] getCycles(int[] array)
    {
        int[][] cycles = new int[array.length][array.length];

        // initialize the cycles to all -1s, cuz they'll never be in the array
        for (int i = 0; i < cycles.length; i++)
        {
            for (int j = 0; j < cycles[i].length; j++)
            {
                cycles[i][j] = -1;
            }
        }

        int i = 0;

        do {
            int nextElement = array[i];

            int j = 0;
            do {
                cycles[i][j] = nextElement;
                nextElement = array[nextElement];
                j++;
            } while (!elementInArray(cycles[i], nextElement) && j < array.length);


            i++;
        }  while (!arrayHasCycled(array, cycles) && i < array.length);


        cycles = removeNegativeOnes(cycles, i);

        for (i = 0; i < cycles.length; i++)
        {
            pushForward(cycles[i]);
        }

        return cycles;
    }

    public boolean elementInArray(int[] array, int element)
    {
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] == element)
                return true;
        }

        return false;
    }

    public int[][] removeNegativeOnes(int[][] cycles, int numCycles)
    {
        int [][] newCycles = new int[numCycles][];
        for (int i = 0; i < numCycles; i++)
        {
            int realLenOfCycle = indexOf(-1, cycles[i]);
            newCycles[i] =  new int[realLenOfCycle];
            for (int j = 0; j < newCycles[i].length; j++)
            {
                newCycles[i][j] = cycles[i][j];
            }
        }

        return  newCycles;
    }

    public int indexOf(int element, int[] array)
    {
        int index =  -1;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == element)
                return i;
        }

        return index;
    }

    public boolean arrayHasCycled(int[] array, int[][] cycles)
    {
        for (int i = 0; i < array.length; i++)
        {
            boolean cycleHasValue = false;
            for (int j = 0; j < cycles.length; j++)
            {
                for (int k = 0; k < cycles[j].length; k++)
                {
                    if (cycles[j][k] == array[i])
                        cycleHasValue = true;
                }
            }
            if (!cycleHasValue)
                return false;
        }

        return true;
    }

    public void pushForward(int [] array)
    {
        int lastElement = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--)
        {
            array[i] = array[i - 1];
        }

        array[0] = lastElement;
    }
}