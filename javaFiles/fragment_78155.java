public static void main(String[] args) {
    String list[] = {"calculator", "catch", "doll", "elephant"};
    Map<Character, List<String>> map = new HashMap<>();

    List<String> lst;
    for (String str : list) {
        //if the key exit then add str to your list else add a new element
        if (map.containsKey(str.charAt(0))) {
            map.get(str.charAt(0)).add(str);
        } else {
            lst = new ArrayList<>();
            lst.add(str);
            map.put(str.charAt(0), lst);
        }
    }
}