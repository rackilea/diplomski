int[][] value = null;
//you can use relative path or full path here
File file = new File("file-name.txt");
try {
    Scanner sizeScanner = new Scanner(file);
    String[] temp = sizeScanner.nextLine().split(" ");
    sizeScanner.close();
    int nMatrix = temp.length;

    Scanner scanner = new Scanner(file);
    value = new int[nMatrix][nMatrix];
    for (int i = 0; i < nMatrix; i++) {
        String[] numbers = scanner.nextLine().split(" ");
        for (int j = 0; j < nMatrix; j++) {
            value[i][j] = Integer.parseInt(numbers[j]);
        }
    }
    scanner.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}