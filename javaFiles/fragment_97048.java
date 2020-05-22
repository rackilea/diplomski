public static int byteCountUTF8(String input) {
    int ret = 0;
    for (int i = 0; i < input.length(); ++i) {
        int cc = Character.codePointAt(input, i);
        if (cc <= 0x7F) {
            ret++;
        } else if (cc <= 0x7FF) {
            ret += 2;
        } else if (cc <= 0xFFFF) {
            ret += 3;
        } else if (cc <= 0x10FFFF) {
            ret += 4;
            i++;
        }
    }
    return ret;
}