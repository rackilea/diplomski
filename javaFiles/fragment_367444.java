Predicate<String> predicate = x -> {
    for (int i = 0 ; i < x.length() ; i++) {
        if (!Character.isLetter(x.charAt(i)) && !x.charAt(i) == '_') {
            return false;
        }
    }
    return true;
};