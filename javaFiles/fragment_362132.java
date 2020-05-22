for (int i = 0; i < Math.pow(2, 3); i++) {
    StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
    while (sb.length() < 3) {
        sb.insert(0, '0');
    }
    System.out.printf("%d = %s%n", i, sb.toString());
}