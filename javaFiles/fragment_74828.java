public class TaxicabPuzzle
{
    public static void main(String[] args)
    {
        int[] myPuzzle = {
            1,3,4,
            0,2,5,
            8,6,7
        };

        int[] goalPuzzle = {
            2,1,0,
            3,4,5,
            8,7,6
        };

        int distanceBound = computeDistanceBound(myPuzzle, goalPuzzle, 3);
        System.out.println("Distance bound: "+distanceBound);
    }

    private static int computeDistanceBound(
        int state[], int goal[], int sizeX)
    {
        int inverseGoal[] = invert(goal);
        int distance = 0;
        for (int i=0; i<state.length; i++)
        {
            int goalIndex = inverseGoal[state[i]];
            distance += distance(i, goalIndex, sizeX);
        }
        return distance;
    }

    // For two indices in an array that represents a 2D array in row-major
    // order, compute the manhattan distance between the positions that are
    // defined by these indices
    private static int distance(int index0, int index1, int sizeX)
    {
        int x0 = index0 % sizeX;
        int y0 = index0 / sizeX;
        int x1 = index1 % sizeX;
        int y1 = index1 / sizeX;
        return Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }

    // Given an array containing the values 0...array.length-1, this
    // method returns an array that contains at index 'i' the index
    // that 'i' had in the given array
    private static int[] invert(int array[])
    {
        int result[] = array.clone();
        for (int i=0; i<array.length; i++)
        {
            result[array[i]] = i;
        }
        return result;
    }
}