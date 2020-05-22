int[] numbers = {10, 20, 15, 56, 22};
double average;
int sum = 0;

for (int number : numbers) {
    sum += number;
}

average = sum / (1.0 * numbers.length);
System.out.println("Average = " + average);