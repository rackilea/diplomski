public static String[][] getStrings(double[][] a) {
    String[][] output = new String[a.length][];
    int i = 0;
    for (double[] d : a){
        output[i++] = Arrays.toString(d).replace("[", "").replace("]", "").split(",");
    }
    return output;
}