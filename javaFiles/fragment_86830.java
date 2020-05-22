public void printSize(Object o) {
    if (o instanceof String) {
        String s = (String) o;
        System.out.println(s.length());
    } else if (o instanceof byte[]) {
        byte[] b = (byte[]) o;
        System.out.println(b.length);
    } else if (o instanceof Integer) {
        Integer i = (Integer) o;
        System.out.println(String.valueOf(i).length());
    // and so on for other types
    } else {
        throw new InputMismatchException("Unknown type");
    }
}