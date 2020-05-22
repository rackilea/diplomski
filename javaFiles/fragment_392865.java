public int[] getNumsFromString (String text) {
    String[] individNums = text.split(" ");
    int[] nums = new int[3];

    int counter = 0;

    for (int i = 0; i < individNums.length; i++) {
        int currentValue = Integer.parseInt(individNums[i]);
        if (currentValue > 11 && counter < 3) {
            nums[counter++] = currentValue;
        }
    }
    return nums;
}