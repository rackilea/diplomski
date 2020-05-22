...
int count = 0, evenSum = 0, evenCount = 0;
double oddSum = 0.0, oddCount = 0.0; //for floating point arithmetic later

while (scan.hasNextInt()) {
  int number = scan.nextInt();
  if (number % 2 == 0) { // even numbers are detected here
    evenSum += number;
    evenCount++; //those detected are counted here.
  }
  else {
    oddSum += number;
    oddCount++;
  }
  count++; //Counts all numbers in the text file
}

System.out.println("Average of odds: " + oddSum / oddCount);
System.out.println("Average of evens: " + evenSum / evenCount);