for (int i=0;i<cPosTags.length;i++) {
    boolean equal = true;
    for (int j=4;j<cPosTags[i].length) {
        if (!cPosTags[i][3].equals(cPosTags[i][j])) {
            equal = false;
            break;
        }
    }
    if (!equal)
        cPosTags[i][2] = "x";
}