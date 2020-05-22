public class Recursion {
    int countRuns(int[] arr, int start, int end) {
        if (start > end) 
            return 0; //checks for null arrays 

        if (start == end) // the indices are inclusive
            return 1;

        int counter; 
        if (arr[start] == arr[start + 1]) {
            counter = 0; // we'll still be in the same run, if they're equal
        } else {
            counter = 1; // otherwise it's a new run
        }

        return counter + countRuns(arr, start + 1, end);
    }
}