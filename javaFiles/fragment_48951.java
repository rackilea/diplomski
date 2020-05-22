int[] arr = new int[13];
int[] inputs = { 18, 41, 22, 44, 59, 32, 31, 73 };
int element = inputs[0] % 13;
for (int j = 0; ; ) {
    if (arr[element] != 0) {
        element++;
        continue;
    }
    arr[element] = inputs[j++];
    if (j == inputs.length)
        break;
    element = inputs[j] % 13;
}
for (int i = 0; i < 13; i++) {
    System.out.print(arr[i] + "  ");
}