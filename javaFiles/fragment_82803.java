void generateCombinations(int n) {
    for(int i = 0; i < (1 << n); i++) {
         for(int j = n - 1; j >= 0; j--) {
            if((i & (1 << j)) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
        System.out.println();
    }
}