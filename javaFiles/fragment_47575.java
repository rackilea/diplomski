public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while(true)
    {
        System.out.println("Want to repeat :");
        if(!sc.next().equalsIgnoreCase("y"))
            break;
        //Prime number
        //isPrimeNumber();

        //Fibonacci series
        //fibonacciSeries();

        //factorial using recursion
        getFactorialOfaNumber();
    }
    sc.close();
}