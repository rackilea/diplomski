private static List<String> breakStringInChunks(final String text, final int chunkSize) {
    final int numChunks = 0 == (text.length() % chunkSize) ? text.length() / chunkSize : 1 + (text.length() / chunkSize);
    final List<String> chunks = new ArrayList<String>(numChunks);
    for (int startIndex = 0; startIndex < text.length(); startIndex += chunkSize) {
        final int endIndex = Math.min(text.length(), startIndex + chunkSize);
        chunks.add(text.substring(startIndex, endIndex));
    }
    return chunks;
}