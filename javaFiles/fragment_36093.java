public static int getFileColumnsNumber(String filename) {
    File file = new File(filename);
    Scanner scanner;
    try {
        scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return -1;
    }

    int number = 0;
    if (scanner.hasNextLine()) {
        number = scanner.nextLine().split(",").length;
    }
    scanner.close();
    return number;
}

public static void main(String[] args) {
    String filename = "test.txt";
    System.out.println(getFileColumnsNumber(filename));
}