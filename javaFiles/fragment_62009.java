int[] numbers = { 2, 2, 5, 6, 6 };
int[] excluded = { 1, 3, 5 };

int sum = 0;
for (int number : numbers) {

    if(Arrays.binarySearch(excluded, number) < 0) {
        sum += number;
    }
}