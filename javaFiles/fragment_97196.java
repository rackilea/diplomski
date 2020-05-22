public static void main(String[] args) {
    new Thread(() -> {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                //... user has input
            }
            else {
                //... user does not have input
            }
    }).start();
    doSomethingElse();
}