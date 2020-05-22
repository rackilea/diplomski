public static void main(String[] args) {
        int[] inputArray = {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] outputArray = sortByHeight(inputArray);

        for (int item : outputArray) {
            System.out.print(item + ", ");
        }
    }

    public static int[] sortByHeight(int[] inputArray) {
        for (int i=0; i<inputArray.length; i++) {
            for (int j = 0; j<inputArray.length - 1; j++) {
                int temp = inputArray[j];
                if (temp >= 0) {
                    int k = j+1;
                    while(inputArray[k] < 0)
                       k++;
                    if (inputArray[j] > inputArray[k] && inputArray[k] >= 0) {
                        inputArray[j] = inputArray[k];
                        inputArray[k] = temp;
                    }
                }
            }
        }
        return inputArray;
    }