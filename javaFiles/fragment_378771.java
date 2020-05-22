public static void main(String[] args) {
    Object o = new String();
    String s = new String();
    o.split("\\."); // compile time error
    s.split("\\."); // works fine

}