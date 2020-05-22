private void doTest(String toCopy) {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < toCopy.length(); i++) {
        buffer.append(toCopy.charAt(i));
    }
    buffer.toString();
}