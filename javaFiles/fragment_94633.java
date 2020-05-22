public String fromHex(String b) {
    char[] cs = new char[b.length() / 4];
    for (int i = 0; i < cs.length; ++i) {
        int c = Integer.parseInt(b.substring(4 * i, 4 * i + 4), 16) & 0xFFFF;
        cs[i] = (char) c;
    }
    return new String(cs);
}