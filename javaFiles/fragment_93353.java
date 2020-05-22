Random random = new Random();
for (int i = 0; i < lineNum; ++i) {
    for (int j = 0; j < numChars; ++j)
        pw.print(charSet.charAt(random.nextInt(charSet.length())));
    pw.println();
}