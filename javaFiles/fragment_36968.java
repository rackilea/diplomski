int NUMBERS_PER_LINE = 10;

for(int i=0; i<50; i++) {
    for (int j=0; j<NUMBERS_PER_LINE; j++) {
        System.out.print(i+j);

        if (j != NUMBERS_PER_LINE-1) {
            System.out.print(",");
        } else {
            System.out.print("\n");
        }
    }
}