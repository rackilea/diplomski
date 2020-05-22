for (int i = 11; i < 100; i++) {
    StringBuffer orig = new StringBuffer();
    String left = orig.append(i).toString();
    if (orig.reverse().toString().equals(left)) {
        System.out.println(left);
    }
}