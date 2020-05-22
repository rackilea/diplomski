import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        eliminateDuplicates(new int[]{1, 2, 1, 2, 3, 3});
    }

    public static int[] eliminateDuplicates(int[] list) {
        int[] distinctList = new int[list.length];
        int i = 0;
        // Iterate through each array elements
        for (int e : list) {
            // Verify if the value already exist. If the number exist return the index of the first apparition, otherwise -1.
            if (linearSearch(distinctList, e) == -1) {
                // Put the value to the distinctList is unique
                distinctList[i] = e;
                // Move to the next position in the distinctList array
                i++;
                System.out.printf("Element %d is not in the distinct array, so it will be added %s\n", e, Arrays.toString(distinctList));
            } else {
                System.out.printf("Element %d already in the distinct array, so it will be skipped\n", e);
            }
        }
        // Return the distinctList that contain only unique values
        return distinctList;
    }

    public static int linearSearch(int[] array, int key) {
        // Iterate through each array elements
        for (int i = 0; i < array.length; i++) {
            // Check the current value of the array (array[i]) if it is the same with the given one return the current index
            if (key == array[i])
                // Same value, no need to search any more, so return from the method with the index of the value
                return i;
        }
        // If the value was not found (the above condition "key == array[i]" was never true)
        return -1;
    }
}