int []numbers = {1,2,3,4,5,6,7,8,9,10};
int smallest = numbers[0];
int sum = 0;

// Find smallest
for (int i = 0; i < numbers.length; i++) {
    sum += numbers[i];

    if (numbers[i] < smallest) {
        smallest = numbers[i];
    }   
}
int sumWithoutSmallest = sum - smallest;

// Remove smallest
int [numbers.length - 1]numbersWithoutSmallest = new int[numbers.length - 1];
int index = 0;
for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] != smallest) {
        numbersWithoutSmallest[index++] = numbers[i];
    }
}