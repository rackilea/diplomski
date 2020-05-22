import java.util.*;

public class Test{
    public static void main(String[] args){
        int[] ttt = {9,8,7,6,5,4,3,2,1};

        bubbleSort(ttt, ttt.length);
    }

    public static void bubbleSort(int[] arr, int n){
        int index = 0;

        System.out.println("Round number: " + n);
        System.out.println(Arrays.toString(arr));

        while(index < n - 1){
            if(arr[index] >  arr[index + 1]){
                swap(arr, index, index + 1);
            }
            index++;
        }

        if(n > 1){
            bubbleSort(arr, n-1);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}