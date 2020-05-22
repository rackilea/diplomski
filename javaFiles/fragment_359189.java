public static void main(String[] args) {
    List<String> x = new ArrayList<String>();
    x.add("abcdef");
    x.add("bcdefg");
    x.add("bbccff");

    Set<Character> all = new HashSet<Character>();
    for (String s : x) {
        for (int i = 0; i < s.length(); i++) {
            all.add(s.charAt(i));
        }
    }

    for (Character c : all) {
        if (charIsCommon(c, x)) {
            System.out.println(c);
        }
    }
}

/*
 * return true only if each string in [list] contains character [c]
 */
private static boolean charIsCommon(char c, List<String> list) {
    for (String s : list) {
        if (s.indexOf(c) < 0) {
            return false;
        }
    }
    return true;
}