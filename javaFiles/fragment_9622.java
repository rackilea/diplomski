public static void ex8(){
    BigInteger num = BigInteger.valueOf(100000L); 

    long time_before = System.currentTimeMillis();
    BigInteger fact = Matematica.factorial(num);
    long time_after = System.currentTimeMillis();

    long time_duration = time_after - time_before;

    System.out.println("Execution time: " + time_duration + " ms " + "AND\n" + "Factorial result: " + fact);
}