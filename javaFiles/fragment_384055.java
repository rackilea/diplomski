public static void main(String[]a) {
    double[][] ds = { { 2.0, 3.1, 3, 7 }, { 1.5, 5.8, 9.6, 1 } };
    for (String[] s : getStrings(ds)){
        System.out.println(Arrays.toString(s));
    }
}