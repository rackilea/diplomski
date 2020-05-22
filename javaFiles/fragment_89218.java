void method(String param1, int param2) {
    String concat = param1 + param2;
    if(concat.length() > 2) {
        int length = concat.length();
        System.out.println("concat is " + length + " character long");
    }
}