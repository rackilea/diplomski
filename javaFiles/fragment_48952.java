int[] arr = new int[13];
int[] inputs = { 18, 41, 22, 44, 59, 32, 31, 73 };
OUTER: for (int i = 0; i < inputs.length; i++) {
    int element = inputs[i] % 13;
    while (arr[element] != 0)
        if (++element == arr.length)
            break OUTER;
    arr[element] = inputs[i];
}
for (int i = 0; i < 13; i++)
    System.out.print(arr[i] + "  ");