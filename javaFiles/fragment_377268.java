public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9,0};
    reverse(arr,0,arr.length-1);
    for (int pr : arr) {
        System.out.print(pr);
    }
}

static void reverse(int[] arr, int start, int end) {
    if (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start + 1, end - 1);
    }
}