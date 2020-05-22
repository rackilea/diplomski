public class InsertionSort {

public int array[] = {10,9,8,7,6,5,4};

public static void main(String[] args) {
    InsertionSort obj = new InsertionSort();
    obj.insertionSortMethod();
    obj.printArray();
}


public void insertionSortMethod() {
    for(int j = 1; j < array.length; j++) {
        int key = array[j];
        int i = j - 1;
        while(i >= 0 && array[i] > key) {
            array[i + 1] = array[i];
            i = i - 1;
    }
        array[i + 1] = key;

    }   
}

public void printArray() {
    for(int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
}

}