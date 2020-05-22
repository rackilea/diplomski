public static void main(String[] args) {
    int[] intArr = new int[5];
    for (int i = 0; i < intArr.length; i++) {
        intArr[i] = 0;
    }
    double[] doubleArr = new double[5];
    for (int i = 0; i < doubleArr.length; i++) {
        doubleArr[i] = 1.11;
    }
    int l = intArr.length;
    int L = doubleArr.length;
    Object[] ob = new Object[l + L];
    for (int i = 0; i < l; i++) {
        ob[i] = intArr[i];
    }
    for (int i = 0; i < L; i++) {
        ob[l + i] = doubleArr[i];
    }
    System.out.println(Arrays.toString(ob));
}