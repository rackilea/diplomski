public static int maxRainfall(double[] arr){
    double max = arr[0];
    int maximum = 0;

    for (int i = 0; i < arr.length; i++){
        if (arr[i] > max){
            max = arr[i];
            maximum = i;
        }
    }
    return maximum;
}