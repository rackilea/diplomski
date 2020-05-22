private static void crossOver(int[] geneA, int[] geneB, int pos) {
    for (int i = pos; i < geneA.length; i++) {
        int temp = geneA[i];
        geneA[i] = geneB[i];
        geneB[i] = temp;
    }
}