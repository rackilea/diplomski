int last = 5;
    for (int i = 1; i <= last; i++) {
        for (int j = last; j > i; j--) {
            System.out.print(" ");
        }
        for (int k = i; k >= 1; k--){
            System.out.print(i);
        }
        System.out.println();  
    }