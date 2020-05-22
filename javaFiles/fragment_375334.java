private static int gcd(int a, int b) {
    while (a != 0 && b != 0) {
        int c = b;
        b = a % b;
        a = c;
    }
    return a + b;
}

public static void main(String[] args) {
    Random random = new Random();

    int iv = 1000000;
    int coprime = 0;

    for (int i = 0; i < iv; i++) {
        int int1 = Math.abs(random.nextInt());
        int int2 = Math.abs(random.nextInt());
        if (gcd(int1, int2) == 1) {
            coprime++;
        }
    }
    System.out.println(Math.sqrt(6.0 * iv / coprime));
}