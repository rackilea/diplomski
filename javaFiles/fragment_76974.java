int array[][] = new int[5][10];
int count = 2;

for(int row=0; row<5;row++){
    for(int col=0;col<10;col++) {
        if (row == 0 && col == 0) {
            continue;
        }
        array[row][col] = count++;
    }
}
for (int[] inner: array) {
    System.out.println(Arrays.toString(inner));
}