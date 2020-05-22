public static void printAllIndex(int[] dimensions) {
    int[] index = new int[dimensions.length];
    int stepNumber = 0;

    // Initialization
    for (int i : index) { index[i] = 0; }         // init index to 0
    for (int d : dimensions) { stepNumber += d; } // count number of iteration needed
    System.out.println(Arrays.toString(index));   // print first index [0,0,...]

    for(int s = 0; s <= stepNumber - 1; s++) {
        boolean allEquals = true;
        int value = index[index.length - 1];
        for (int i = index.length - 1; i >= 0; i--) {
            if(index[i] != value) {
                index[i]++;
                allEquals = false;
                break;
            }
        }
        if (allEquals) { index[index.length - 1]++; }
        System.out.println(Arrays.toString(index));
    }
}