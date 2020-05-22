public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    System.out.println("Enter an integer");
    int size = scanner.nextInt();

    int[][] array = new int[size][2];

    for (int i = 0; i < size; i++) {
        String myInt = scanner.next();
        String[] myInts = myInt.split(" ");
        for (int j = 0; j < 2; j++) {
            array[i][j] = Integer.parseInt(myInts[j]);
        }
    }
    // print contents
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < 2; j++) {
            System.out.println("[" + i + "]" + "[" + j + "] = " +array[i][j]);
        }
    }        
}