int oddCount = 0;
int sum = 0;
for (int number = 1; number <= 100; ++number) { // for loop
  if (number % 2 != 0) {
     sum += number;
     oddCount++;
  }
}
System.out.println(sum / (double) oddCount)