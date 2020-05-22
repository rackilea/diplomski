public void scan(Scanner scanner) {
    while (scanner.hasNext()) {
        String next = scanner.next();
        System.out.println("opening inner scanner: " + next);
        Scanner innerScanner = new Scanner(next);
        do {
            next = innerScanner.findInLine("([-]?\\d+)|(pear)|([a-zA-Z])");
            if (next == null) {
                // Nothing useful in there
            } else if (next.equals("pear")) {
                System.out.println("pear");
            } else if (next.matches("[a-zA-Z]")) {
                System.out.println("char: " + next);
            } else {
                System.out.println("number: " + next);
            }
        } while (next != null);
        innerScanner.close();
    }
}

public void run() {
    scan(new Scanner("123 d 456 pear"));
    scan(new Scanner("123d456pear"));
}