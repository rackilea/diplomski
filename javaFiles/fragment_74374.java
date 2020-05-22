import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

// Java program to calculate all permutations using 
// Heap's algorithm 
class HeapAlgo 
{ 
    List<int[]> heapPermutation(int a[]) {
        LinkedList<int[]> list = new LinkedList<int[]>();
        heapPermutation(a, a.length, a.length, list);
        return list;
    }

    //Generating permutation using Heap Algorithm 
    void heapPermutation(int a[], int size, int n, List<int[]> list) 
    { 
        // if size becomes 1 then adds the obtained 
        // permutation to the list
        if (size == 1) 
            list.add(a.clone());

        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n, list); 

            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 

            // If size is even, swap ith and last 
            // element 
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 

    // Driver code 
    public static void main(String args[]) 
    { 
        HeapAlgo obj = new HeapAlgo(); 
        int a[] = {1,2,3}; 
        List<int[]> list = obj.heapPermutation(a);
        for(Iterator<int[]> i = list.iterator(); i.hasNext();) {
            int[] array = i.next();
            for(int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    } 
} 

// Based on code contributed by Amit Khandelwal.