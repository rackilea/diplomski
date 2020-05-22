public class Sort {

   public static int[] selection(int[] array) {
        return sRec(array,0);
    }
    private static int[] sRec(int[] array, int current) {
      if (current == array.length-1) { //last index of array = index we are at
            return array; //it's sorted
        }
        else {
                int indexOfBiggest = findBig(array, current,array.length-1);
                int[] swapped = swap(array, indexOfBiggest, current );
                return sRec(swapped, current+1);
        }
    }

    private static int[] swap(int[] array, int index, int lastPos) {
        int temp = array[lastPos];
        array[lastPos] = array[index];
        array[index] = temp;
        return array;
    }

    private static int findBig(int[] array, int begin, int end) {
        if (begin < end) {
            int middle = (begin+end)/2;
            int biggestLeft = findBig(array,begin,middle);
            int biggestRight = findBig(array,middle+1,end);
            if(array[biggestLeft] > array[biggestRight]) {
                return biggestLeft;
            }else {
                return biggestRight;
            }
        }else {
            return begin;
        }
     }

    public static void main (String [] args) {
        int[] array = {8,3,5,1,3};
       // System.out.println(findBig(array,0,array.length-1));
        int[] sorted = selection(array);
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }
}