public static void stringOrder(String a, String s, String d) {
    String [] arr = {a, s, d};
    java.util.ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
    java.util.Collections.sort(list);
    sayName(list.get(0), list.get(1), list.get(2));
}