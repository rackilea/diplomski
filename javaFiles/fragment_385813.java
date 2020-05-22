final int MAX = 36;
final long count = 1L * MAX * MAX * MAX * MAX * MAX * MAX * MAX * MAX * MAX * MAX;

final char[] alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
final int[] digits = new int[8];
final char[] output = "00000000".toCharArray();

for (long i = 0; i < count; ++i) {
    final String name = String.valueOf(output);

    // "increment"
    for (int d = 7; d >= 0; --d) {
        digits[d] = (digits[d] + 1) % MAX;
        output[d] = alphabet[digits[d]];
        if (digits[d] > 0) {
            break;
        }
    }

}