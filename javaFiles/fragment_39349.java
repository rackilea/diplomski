int dim = block.length;

for (int i=0; i <= (dim - 1)/2; i++) {
    for (int j=i; j < dim - i - 1; j++) {
        int p1 = block[i][j];
        int p2 = block[j][dim-i-1];
        int p3 = block[dim-i-1][dim-j-1];
        int p4 = block[dim-j-1][i];

        block[j][dim-i-1] = p1;
        block[dim-i-1][dim-j-1] = p2;
        block[dim-j-1][i] = p3;
        block[i][j] = p4;
    }
}