package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        int fibonacciNumber = 6;
        System.out.println("Fibonacci #" + fibonacciNumber + " = " + new Application().calcFibonacci(fibonacciNumber));
    }

    @Log
    public int calcFibonacci(int n) {
        return n <= 1 ? n : calcFibonacci(n - 1) + calcFibonacci(n - 2);
    }
}