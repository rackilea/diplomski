public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    double[] userVals = new double[5];

    System.out.print("Enter 5 numbers: ");
    for(int i=0;i< 5;i++){
        userVals[i]= scnr.nextDouble();
    }

    System.out.print("Minimum number: "+ getMin(userVals));

}

 public static double getMin(double[] array) {
    double minNum = array[0];

    for (int i = 0; i < array.length; ++i) {
        if (array[i] < minNum) {
            minNum = array[i];
        }
    }
    return minNum;
}