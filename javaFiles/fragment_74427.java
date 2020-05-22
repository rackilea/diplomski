private static void printFactor(int number) 
    System.out.print(1);
    int factor = 2;
    while (factor<number) {
        if (number%factor == 0) System.out.print(" + " + factor);
        factor++;
    }
}