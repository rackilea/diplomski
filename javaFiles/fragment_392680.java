public static void main(String[] args) {
    byte[] data = new byte[64*1024*1024];
    long start = System.nanoTime();
    int sum = 0;
    for (byte b : data) {
        sum += b;
    }
    long end = System.nanoTime();
    System.out.println(new BigDecimal(end - start).movePointLeft(9));
}