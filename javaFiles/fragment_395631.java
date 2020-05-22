public static void main(String[] args) throws IOException {
    Scanner s = new Scanner(System.in);
    String invoer;
    String invoer2;
    System.out.print("Fill in your name:");
    invoer = s.next();
    System.out.print("Fill in your age:");
    try {
        invoer2 = s.nextInt();
        for (int i = 0; i < invoer2; i++) {
            System.out.println(invoer);
        }
    } catch (InputMismatchException e) {
        System.out.println("It wasn't valid age");
    }
    System.out.print("" + invoer);
    System.out.print(" " + invoer2);
}