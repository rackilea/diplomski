final int maxRange = 122 - 97;
Random random = new Random();
for (long i = 0L; i < 100L; i++) {
    int codePoint = random.nextInt(maxRange) + 97;
    // ...
}