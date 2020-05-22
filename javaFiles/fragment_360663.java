public class StackExchange {
    public static

 void mergeSort(int A[], int l , int r) {

    if (l < r) {
        int m = (l+r)/2; 
        mergeSort(A, l , m);
        mergeSort(A, m+1, r);
        merge(A, l, m, r);
    }

}

private static void merge(int[] A, int l, int m, int r) {

    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0 ; i < n1; i++) {
        L[i] = A[l+i];
    }

    for (int j = 0 ; j < n2; j++) {
        R[j] = A[m + 1 + j];
    }

    int i = 0, j = 0 , k = l;

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            A[k] = L[i];
            i++;
        } else {
            A[k] = R[j];
            j++;
        }

        k++;
    }

    while (i < n1) { 
        A[k] = L[i]; 
        i++; 
        k++; 
    }

    while (j < n2) { 
        A[k] = R[j]; 
        j++; 
        k++; 
    }
}

public static void main (String...s) {
    int array[] = new int[] {12, 21, 32, 36, 14, 10, 11, 5, 55, 16, 31, 7, 57, 89, 78};

    mergeSort(array, 0, array.length - 1);

    printArray(array);
}

private static void printArray(int array[]) {
    for (int i : array) {
        System.out.println(i + " -- ");
    }
}
}