public static double milesToLaps(double userMiles) {
    return userMiles * 4;
}

public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    double userMiles = scnr.nextDouble();
    System.out.printf("%.2f%n", milesToLaps(userMiles));
}