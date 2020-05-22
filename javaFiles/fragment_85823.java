public static int[] inBinary(int number) {
    // this will store the full binary array
    int[] binary = new int[Integer.SIZE];
    for (int i = Integer.SIZE - 1; 0 <= i; i--) {
        binary[i] = number % 2;
        // one shift to the right, basically divides with two
        // it's okay to change the incoming parameter as it's not a reference
        number = number >> 1;
    }

    // then we count the leading zeros
    int startIndex = 0;
    while (binary[startIndex] != 1) {
        startIndex++;
    }

    // Arrays.copyOfRange() is prohibited so we have to do it manually:
    // We allocate a shorter array
    int[] result = new int[Integer.SIZE - startIndex];
    // and copy the related numbers.
    for (int i = 0; i < Integer.SIZE - startIndex; i++) {
        result[i] = binary[startIndex + i];
    }

    return result;
}