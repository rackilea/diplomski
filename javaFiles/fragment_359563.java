package Sortieralgorithmus;

public class sort {

public static int[] straightSelection(int[] numbers) {
int i, j;  // declare them here 
int smallestIndex; //declare it here as well

for (i = 0; i < numbers.length-1; i++) {
    smallestIndex = i;

    for (j = i + 1; j < numbers.length; j++) {
        if (numbers[j] < numbers[smallestIndex]) {
            smallestIndex = j;
        }
    }
    if(smallestIndex != i){
    swap(smallestIndex, i, numbers);
    }

}

return numbers;
}
}