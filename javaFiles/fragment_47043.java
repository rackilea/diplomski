for(int row = 1; row <= input1; row++) {
    for(int space = 0; space < input1-row; space++) {
        System.out.print(" ");
    }
    for(int desc = row; desc > 1; desc--) {
        System.out.print(desc);
    }
    for(int asc = 1; asc <= row; asc++) {
        System.out.print(asc);
    }
System.out.println();
}