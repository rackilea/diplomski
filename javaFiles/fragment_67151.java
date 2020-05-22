StringBuilder builder = new StringBuilder(secret);
for (int i = 0; i < original.length(); i++) {
    if (original.charAt(i) == guessLetter) {
        builder.setCharAt(i, guessLetter);
    }
}
secret = builder.toString();