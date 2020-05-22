int Fibonacci(int n) {

    System.out.println(n + "N");

    if (n <= 1) {
        return n;
    } else {
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

}