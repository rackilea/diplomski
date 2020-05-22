public static void main(String[] args) {
        Random random = new Random();
        int montab[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 25, 50, 75, 100 };
        int[] ar1 = new int[6];
        int j = 0, count = 0;
        while (j < ar1.length) {
            count = 0;
            int index = random.nextInt(montab.length);
            int num = montab[index];
            if (num >= 25) { //adds any number greater or equal to 25
                ar1[j] = num;
                j++;
                montab[index] = 0; // replace the origianl array with 0.
            } else if (num != 0) {
                if(!isRepeated(ar1,num)){ //checks if the array has more than two of the number.
                ar1[j] = num;
                j++;
                }
            }
        }
        for (int i = 0; i < ar1.length; i++) {
            System.out.print(ar1[i] + " ⎢ " + "\t");
        }
    }

    public static boolean isRepeated(int[] arr, int num) { //method that verifies if the array has a number repeated twice or not.
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                count++;
        }
        return count==2 ? true : false;
    }