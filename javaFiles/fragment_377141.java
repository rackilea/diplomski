public static void main(String[] args) {
    int maxSize = Integer.MAX_VALUE - 2;
    long start = System.currentTimeMillis();
    StringBuilder sb = new StringBuilder(maxSize);
    while (sb.length() < maxSize)
        sb.append(' ');
    long time = System.currentTimeMillis() - start;
    System.out.println("Took " + time / 1e3 + " second to create a StringBuilder of " + sb.length());
}