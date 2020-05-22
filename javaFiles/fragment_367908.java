public static int count(double[][][] list) {
    int count = 0;
    for (int j=0; j < list.length; j++) {
        for (int k=0; k < list[j].length; k++){
            count += list[j][k].length;
        }
    }
    return count;
}