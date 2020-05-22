private static void onesComplements(int[] binary) {
    for (int i = 0; i < binary.length; i++) {// will perform one's complement
        if (binary[i] == 0) {
            binary[i] = 1;
        } else {
            binary[i] = 0;
        }
    }
}

private static void twosComplement(int[] binary) {
    int carry = 1;
    for (int i = binary.length - 1; i >= 0; i--) {// will perform two's complement by adding one
        if (carry == 1) {
            if (binary[i] == 0) {
                binary[i] = 1;
                carry = 0;
                break;
            } else {
                binary[i] = 0;
            }
        }
    }
}

private static void handleNegativeNumbers(int[] binary) {
    onesComplements(binary);
    twosComplement(binary);
}