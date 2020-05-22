int oddCount = 0;
int sum = 0;
for (int number = 1; number <= 100; number += 2) { // <-- skip the even values.
  sum += number;
  oddCount++;
}
System.out.println(sum / (double) oddCount)