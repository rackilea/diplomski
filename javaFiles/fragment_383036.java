public static void main(String[] args) {
    System.out.println(Arrays.toString(reverseAscendingSubArray(new int[]{5, 7, 10, 4, 2, 7, 8, 1, 3})));
}

private static int[] reverseAscendingSubArray(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        if (i == 0 || arr[i - 1] < arr[i]) {
            stack.push(arr[i]);
        } else {
            for (int j = stack.size(); j > 0; j--) {
                result[i - j] = stack.pop();
            }
            stack.push(arr[i]);
        }
    }
    if (!stack.empty()) {
        for (int j = stack.size(); j > 0; j--) {
            result[arr.length - j] = stack.pop();
        }
    }
    return result;
}