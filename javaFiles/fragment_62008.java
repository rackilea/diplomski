int[] numbers = { 2, 2, 5, 6, 6 };

int sum = 0;
for (int number : numbers) {
    if(number % 2 == 0) {
        sum += number;
    }
}