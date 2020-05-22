public static void main(String[] args) {
    long tal = 600851475143L;
    int i;
    for (i = 2; i <= tal; i++) {
        if (tal % i == 0) {
            tal /= i; i--;
        }
    } 
    System.out.println("largest prime factor is " + i); // largest prime factor is 6857
}