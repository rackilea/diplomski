public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<String, Integer>();

    map.put("Hello", 0);
    map.put("World!", 1);

    Map<Integer, String> inv = invert(map);

    System.out.println(inv); // outputs something like "{0=Hello, 1=World!}"
}