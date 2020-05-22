static void decode(String s, int index, byte[] decode, int size) {
    if (index >= s.length())
        System.out.println(new String(decode, 0, size));
    else
        for (int i = index + 1; i <= s.length(); ++i) {
            int d = Integer.parseInt(s.substring(index, i));
            if (Character.isISOControl(d)) continue;
            if (d > 255) break;
            decode[size] = (byte)d;
            decode(s, i, decode, size + 1);
        }
}

static void decode(String s) {
    decode(s, 0, new byte[s.length()], 0);
}