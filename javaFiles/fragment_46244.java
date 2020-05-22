public class Test {
    public static void main(String[] args) {
        int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        FindLargestInColumn(array, 2);
        FindSumforRow(array,2);
    }

    public static void FindLargestInColumn(int list[][], int index) {
        int largest = -1;
        for (int[] row : list) {
            if (row[index] > largest)
                largest = row[index];
        }
        System.out.println("The Largest value in column " + (index )+ " is " + largest);
    }
    public static void FindSumforRow(int list[][], int rowIndex) {
        int sum = 0;
        int[] row = list[rowIndex];
        for (int value : row) {
            sum  = sum + value;  
        }
        System.out.println("The Sum of value in row  " + (rowIndex)+ " is " + sum);
    }
}