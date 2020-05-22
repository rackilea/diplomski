public static void main(String... args) throws Exception {
    List<Character> myList = Arrays.asList('2', '3', 'a', 'b', 'c', '3', '5', '£', 'a', '4', '5', '=');
    List<String> grouped = new ArrayList<>();
    StringBuilder group = new StringBuilder();
    String prevType = null;
    for (Character ch : myList) {
        String type = typeOf(ch);
        if (prevType != null && type != prevType) {
            grouped.add(group.toString());
            group.setLength(0);
        }
        group.append(ch);
        prevType = type;
    }
    grouped.add(group.toString());
    System.out.println("myList= " + myList);
    System.out.println("newList= " + grouped);
}

private static String typeOf(Character ch) {
    return Character.isDigit(ch) ? "digit" :
            Character.isAlphabetic(ch) ? "alpha" :
                    "other";
}