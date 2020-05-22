public static String increment(final String p_source) {
    final int first = (p_source.charAt(0) - 'A') * 26;
    final int second = p_source.charAt(1) - 'A';

    final int next = (first + second + 1) % (26*26); 

    return new String(new byte[] {(byte)(next / 26 + 'A'), (byte)(next % 26 + 'A')});
}