public static boolean isStringValid(String str) {
    String[] splitString = str.split(" ");
    boolean test1 = splitString.length == 2;
    boolean test2 = true;
    for (String s : splitString) {
        if s.length() < 2 {
            test2 = false;
        }
    }

    if (test1 && test2) {
        return true;
    }
    return false;
}