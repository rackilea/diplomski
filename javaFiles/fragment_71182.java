public static void displayAvgTemp(int[] temp) {
    //its a problem that temp[] starts from index 0
    //so I shift elements with 1 to right, so I can iterate starting from index 1
    int[] tempShifted = new int[temp.length+1];
    System.arraycopy(temp, 0, tempShifted, 1, temp.length);
    float sum = 0;
    for (int i = 1; i < tempShifted.length; i++) {
        sum += tempShifted[i];
        if (i % 30 == 0) {
            System.out.println(sum / 30);
            sum = 0;
        }
    }
}