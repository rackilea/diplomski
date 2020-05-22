private static void containsNameWithSameFirstCharacter(Collection<String> names, String name) {
    for (String anotherName : names) {
        if (anotherName.charAt(0) == name.charAt(0)) {
            return true;
        }
    }
    return false;
}