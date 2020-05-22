public static void getCount(String name) {
    Map<Character, Integer> names = new HashMap<Character, Integer>();
    for(int i = 0; i < name.length(); i++) {
        char c = name.charAt(i);
        Integer count = names.get(c);
        if (count == null) {
            count = 0;
        }
        names.put(c, count + 1);
    }
    Set<Character> a = names.keySet();
    for (Character t : a) {
        System.out.println(t + " Ocurred " + names.get(t) + " times");
    }
}