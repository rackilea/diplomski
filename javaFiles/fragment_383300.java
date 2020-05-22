public class sortTesting {

public static void main(String[] args) {

    QuickSort qsort = new QuickSort();
    SelectionSort ssort = new SelectionSort();

    int i;
    int numbers[] = { 12, 9, 4, 99, 120, 1, 3, 10 };

    System.out.print("Values in the sort:\n");

    for (i = 0; i < numbers.length; i++) {
        System.out.print(numbers[i] + "  ");
        System.out.println();
    }     
    int []numbers2=numbers.clone();
    qsort.quickSort(numbers, numbers.length);/*MENTION THE CORRECT ARRAY LENGTH*/        
    System.out.println("\nThe array after sorting using quick sort is");
    for(int e:numbers)
     System.out.print(e+"  ");    
    ssort.selectionSort(numbers2, numbers2.length);/*MENTION THE CORRECT ARRAY LENGTH*/    
    System.out.println("\nThe array after sorting using selection sort is");
    for(int e:numbers2)
     System.out.print(e+"  ");         
 }

}