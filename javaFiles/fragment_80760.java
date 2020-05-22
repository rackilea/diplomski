// Core algorithm.
public static int sumDigits(int num) {
    int sum = 0;
    while (num > 0) {
        sum += num % 10;
        num = num / 10;
    }
    return sum;
}

public static void sumNumber() {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter a number");
    int numA = in.nextInt();
    System.out.println("Enter another number");
    int numB = in.nextInt();
    int totalDigits = sumDigits(numA) + sumDigits(numB);
    System.out.println(totalDigits);
}