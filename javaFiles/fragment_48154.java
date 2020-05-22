public static long factorial(long n) {
    if(n == 0 || n == 1) {
      System.out.print(1 + " ");
      return 1;
    }

    long result = n * factorial(n - 1);
    System.out.print(result + " ");
    return result;
  }