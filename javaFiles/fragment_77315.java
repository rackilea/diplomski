for (int x = 9999; x < 100000; x++) {
    int n = x;
    int b = x * 4;
    String number = Integer.toString(n);
    String backwards = Integer.toString(b);
    StringBuilder sb = new StringBuilder(number);
    sb.reverse();
    if (sb.toString().equals(backwards)) {
        System.out.printf("%s * 4 = %s", number, backwards);
    }
}