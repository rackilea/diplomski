public static boolean isPrime(int value) {
  if (value <= 1)
    return false;

  // There's only one even prime: that is two 
  if ((value % 2) == 0) 
    return (value == 2);

  int from = (int) (Math.sqrt(value) + 1);

  // You have to check possible divisors from 3 to sqrt(value)
  for (int i = 3; i <= from; i += 2)
    if ((value % i) == 0)
      return false;

  return true;
}

public static void main(String[] args) {
  ...

  for (int i = 1; i <= 100; ++i) {
    if (isPrime(i)) 
      System.out.println(i);
    else {
      // i is not prime. You can do nothing, throw an exception etc
      // throw new MyException("Not a prime"); 
    }
  }
}