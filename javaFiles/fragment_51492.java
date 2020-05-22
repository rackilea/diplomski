int byteCount(int codePoint) {
    int[] codePoints = new int[] { codePoint };
    String s = new String(codePoints, 0, codePoints.length);
    int byteCount = s.getBytes(StandardCharsets.UTF_8).length;
    return byteCount;
}