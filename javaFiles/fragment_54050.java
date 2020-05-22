public static void main(String[] args)
    {
        int[] numbers1 = {0,2,4,6,7,11,0};
        int[] numbers2 = {-7,5,9,10,5,0};
        System.out.println(findTarget(numbers1,5));
        System.out.println(findTarget(numbers1,0));
        System.out.println(findTarget(numbers2,5));
        System.out.println(findTarget(numbers1,-1));
    }
    public static int findTarget(int[] arr, int target)
    {
        if (arr == null) {
            return -1;
        }
        int targetIndex = -1;
        for(int i = 0; i <= arr.length-1; i++) {
            if (target == arr[i]) {
                targetIndex = i;
            }
        }
        return targetIndex;
    }