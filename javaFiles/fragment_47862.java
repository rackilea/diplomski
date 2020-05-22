int foundprimenumbers = 0;

for (i = 2; i <= maxprime; i++) {
      if (PrimeNumbers(i)) {
        System.out.println(i);
        foundprimenumbers++;
      }
}   
// System.out.println("Prime numbers are " + foundprimenumbers);   
System.out.println("There are " + foundprimenumbers + " prime numbers found.");