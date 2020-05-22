int[] arr = {3, 7, 7, 3};
boolean isMirror = true;

for (int i = 0; i <= arr.length/2; i++) {
    int j = arr.length - 1 - i;
    if (arr[i] != arr[j]) {
        isMirror = false;
        break;
    }
}
if (isMirror) {
    System.out.println("The array is mirror-like");
} else {
    System.out.println("The array is not mirror-like");
}