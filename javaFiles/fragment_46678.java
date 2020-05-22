int i, j, k;
for (i = 0; i < 3; i++) {
    for (j = 0; j < 4; j++) {
        for (k = 0; k < 5; k++) {
            System.out.printf("%d %d %d %d %n", i, j, k, i * j * k);
            threeD [i][j][k] = i*j*k;
        }
    }
} // move to here ...
for (i = 0; i < 3; i++) {
    for (j = 0; j < 4; j++) {
        for (k = 0; k < 5; k++) {
            System.out.print(threeD[i][j][k]+"  ");
        }
        System.out.println("");
    }
    System.out.println("");
}
// ... from here