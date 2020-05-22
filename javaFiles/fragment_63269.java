System.out.println("enter the string");
Scanner sc= new Scanner(System.in);
String s1=sc.nextLine();
if (s1 != null && !s1.isEmpty()) {
    // will display character counts alphabetically
    Map<Character, Integer> count = new TreeMap<Character, Integer>();
    char[] chars = s1.toCharArray();
    for (char c: chars) {
        // no count yet for this character
        if (count.get(c) == null) {
            count.put(c,  1);
        }
        // this character appeared at least once: incrementing count
        else {
            count.put(c,  count.get(c) + 1);
        }
    }
    System.out.println(count);
}