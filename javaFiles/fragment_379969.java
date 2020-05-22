for(int i = 0; i < 6; i++) {
    for(int j = 0; j < 13; j++) {
        if(j == i * 2 + 1) {     
            System.out.print(" - ");
        }
        else {
            System.out.print("*");
        }
    }
    System.out.println();
}