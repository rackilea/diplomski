public static void main(String[] args) {
    System.out.println("Enter String:");
    Scanner kb = new Scanner(System.in);
    String old = kb.nextLine();
    StringBuilder sb = new StringBuilder();
    Map<Character, Character> map = new HashMap<>();
    map.put('i', 'e');
    map.put('e', 'a');
    map.put('a', 'i');

    for (char ch : old.toCharArray()) {
        if (map.containsKey(ch)) {
            sb.append(map.get(ch));
        } else {
            sb.append(ch);
        }
    }
    System.out.println("\n The Output is=" + sb.toString());
}