// sum the columns first
for (int i=0; i < a.length; i++) {
    for (int j=0; j < a[0].length; j++) {
        c[j] += a[i][j];
    }
}

// then iterate c[] once at the end and print it
for (int j=0; j < a[0].length; j++) {
    System.out.print(c[j] + "\t");
}