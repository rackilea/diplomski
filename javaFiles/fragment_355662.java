import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {    
    public void mergeSort(Integer[] array, int lo, int n) {
        int low = lo;
        int high = n;
        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;
        mergeSort(array, low, middle);
        mergeSort(array, middle + 1, high);
        int end_low = middle;
        int start_high = middle + 1;
        while ((lo <= end_low) && (start_high <= high)) {
            if (array[low] < array[start_high]) {
                low++;
            } else {
                int Temp = array[start_high];
                for (int k = start_high - 1; k >= low; k--) {
                    array[k + 1] = array[k];
                }
                array[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        MergeSort pb = new MergeSort();
        try {
            BufferedReader br = new BufferedReader(new FileReader("E:\\task.txt"));
            List<Integer> lines = new ArrayList<Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            br.close();
            Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
            pb.mergeSort(inputArray, 0, inputArray.length - 1);
            for (Integer i : inputArray) {
                System.out.println(i);
            }
        } catch (IOException ie) {
            System.out.print(ie.getMessage());
        }

    }
}