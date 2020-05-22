public static boolean trueorfalse(String on, String surname, 
        double money, double cost) {
    boolean accepted = get.money > 50.0 && get.cost < 100.0;
    String msg = accepted ? "accepted" : "denied";
    System.out.printf("Money is %.2f%n", money);
    System.out.printf("Name and %s %s%n", msg, on);
    System.out.printf("Surname and %s %s%n", msg, surname);
    return accepted;
}