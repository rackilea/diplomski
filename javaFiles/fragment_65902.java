private static String intersectionOf(String s1, String s2) {
    List<Character> list1 = new ArrayList<>();
    for(char c : s1.toCharArray()) {
        list1.add(c);
    }
    List<Character> list2 = new ArrayList<>();
    for(char c : s2.toCharArray()) {
        list2.add(c);
    }

    StringBuilder intersection = new StringBuilder();
    for(Character c : list1) {
        if(list2.contains(c)) {
            intersection.append(c);
            list2.remove(c); // remove it so it is not counted twice
        }
    }
    return intersection.toString();
}