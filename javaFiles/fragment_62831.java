private static void table(String[] args) {
    int numToAdd = Integer.parseInt(args[1]);
    int[][] table = new int[10][10];
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.printf("%6d", i * j + numToAdd);  
        }
        System.out.println();
    } 
}