public static boolean isPrime(int number){
    if (number != 2) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println(number + " is composite");
                return false;
            }
        }
    }
    System.out.println(number + " is prime");
    return true;
}