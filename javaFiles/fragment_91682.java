public static void powerOfTwo(long a) {
    if ((a & (a - 1)) == 0)
        System.out.println("it's a power of two");
    else
        System.out.println("NOT a power of two");
}