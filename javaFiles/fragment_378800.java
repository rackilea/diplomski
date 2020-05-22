File file = new File("example.txt");
try {
    Scanner scanner = new Scanner(file);
    while(scanner.hasNextInt()){
        int input = scanner.nextInt();
        // Do whatever you were doing with the input
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}