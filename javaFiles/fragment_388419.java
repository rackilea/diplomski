Scanner scanner = null;
try {
    File f = new File("/home/efrisch/test.txt");
    scanner = new Scanner(f);
    while (scanner.hasNextInt()) {
        System.out.println(isArmstrong(scanner.nextInt()) ? "True"
                : "False");
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (scanner != null) {
        scanner.close();
    }
}