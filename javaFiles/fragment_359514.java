public void checkInt() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Eneter a nuber here:");
    try {
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.print("this is even!!");
        } else {
            System.out.println("this is odd!!");
        }
    } catch (InputMismatchException e) {
        System.out.println("pleas enter an integer only!!!");
        checkInt();
    }
}