int max = Integer.MIN_VALUE;
while (strTok.hasMoreTokens()) {
    int value = Integer.parseInt(strTok.nextToken());
    if (value > max) {
        max = value;
    }
}