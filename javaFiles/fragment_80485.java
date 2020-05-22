static String shiftRows(String text) {
    char[] chs = text.toCharArray();
    StringBuilder samBuffer = new StringBuilder();
    for (int i = 0; i < chs.length; i++)
        samBuffer.append(String.format("%02x", (int)chs[i])); // always 2 hex digits, even for 0-15
    return samBuffer.toString();
}

public static void main(String[] args) {
    String text = shiftRows("WVOGJTXQHUHXICWYYMGHTRKQHQPWKYVGLPYSPWGOINTOFOPMO");
    if (text != null && ! text.isEmpty()) {
        int len = (text.length() + 31) / 32 * 32; // round up to next increment of 32 (16 hex pairs)
        for (int i = 0; i < len; i += 2) {
            if (i != 0 && i % 8 == 0) { // every 4 hex pairs, but not first time
                System.out.println();
                if (i % 32 == 0) // every 16 hex pairs
                    System.out.println();
            }
            if (i < text.length())
                System.out.print(text.substring(i, i + 2) + " ");
            else
                System.out.print("41 ");
        }
    }
}