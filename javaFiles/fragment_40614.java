private void generatePassword(char[] charset) {
    final StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < passLength; i++) {
        char c = charset[random.nextInt(charset.length)];
        sb.append(c);
    }

    final String output = sb.toString();
    passView.setText(output);
}