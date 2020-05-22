public static void main(String[] args) throws Exception {
    System.out.println(test("BFEABLDEG", "LABEL"));
}

public static boolean test(String searchIn, String searchFor) {
    for (char c : searchFor.toCharArray()) {
        if (searchIn.indexOf(c) == -1) {
            return false;
        }
        searchIn = searchIn.replaceFirst(Character.toString(c), "");
    }
    return true;
}