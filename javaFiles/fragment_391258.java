class ArrayTest {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int[] indexes = indexesOfTopElements(arr,3);
        for(int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            System.out.println(index + " " + arr[index]);
        }
    }

    static int[] indexesOfTopElements(int[] orig, int nummax) {
        int[] copy = Arrays.copyOf(orig,orig.length);
        Arrays.sort(copy);
        int[] honey = Arrays.copyOfRange(copy,copy.length - nummax, copy.length);
        int[] result = new int[nummax];
        int resultPos = 0;
        for(int i = 0; i < orig.length; i++) {
            int onTrial = orig[i];
            int index = Arrays.binarySearch(honey,onTrial);
            if(index < 0) continue;
            result[resultPos++] = i;
        }
        return result;
    }

}