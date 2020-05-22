import java.io.*;
import java.util.*;

public class SortingAnalysis {

    public static void merge(String[] A, int p, int q, int r) {
        int n1 = q-p+1;
        int n2 = r-q;
        if(A[p]==null || A[q]==null)return;
        String[] L = new String[n1+1];
        String[] R = new String[n2+1];
        for (int i=0; i<n1; i++) {
            L[i] = A[p+i];
        }
        for (int j=0; j<n2; j++) {
            R[j] = A[q+j +1];
        }
        L[n1] = "zzzzz"; //for infinity because if I use Math.floor, it will return a double
        R[n2] = "zzzzz";
        int i=0;
        int j=0;
        for (int k=p; k<=r; k++) {
            int comparison = L[i].compareTo(R[j]);
            if (comparison <= 0){
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }

        }

    }

    public static void mergeSort (String[] A, int p, int r) {
        if (p<r) {
            int q = (p+r)/2;
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    public static void main(String[] args) {
        final int NO_OF_WORDS = 50000;
        try {
            Scanner file = new Scanner("bla blya blay byla ybla");
            ArrayList<String> words = new ArrayList<String>();

            while(file.hasNext() && words.size() < NO_OF_WORDS) {
                words.add(file.next());
            }
            String [] wordsArray = new String[words.size()];
            words.toArray(wordsArray);
            long start = System.currentTimeMillis();

            mergeSort(wordsArray, 0, wordsArray.length-1);

            long end = System.currentTimeMillis();
            System.out.println("Sorted Words: ");
            for(int j = 0; j < wordsArray.length; j++) {
                System.out.println(wordsArray[j]);
            }   
            System.out.print("Running time: " + (end - start) + "ms");

        }
        catch(SecurityException securityException) {
            System.err.println("Error");
            System.exit(1);
        }

    }
}