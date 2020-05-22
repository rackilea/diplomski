public static void main(String[ ] args) {
      double[] fib = new double[100];
      fib[0] = 1;
      fib[1] = 1;
      int counter = 2;
      double n1, n2, fibSum;
      System.out.println(fib[0]);
      System.out.println(fib[1]);
      while(counter < fib.length){
          n1 = fib[counter-1];
          n2 = fib[counter-2];
          fibSum = n1 + n2;
          System.out.println(fibSum);
          fib[counter] = fibSum;
          counter++;
      }
}