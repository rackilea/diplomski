int[][] convertToPrimitives(Integer[][] documents) {
    int[][] primitives = new int[documents.length][];
    for (int i=0;i<documents.length;i++) {
        primitives[i] = new int[documents[i].length];
        for (int j=0;j<documents[i].length;j++) {
            primitives[i][j] = documents[i][j];
        }
    }
    return primitives;
}