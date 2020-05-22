public static boolean isEqual(List<TermNode> one, List<TermNode> two) {
    if(one == null && two == null) {
        return true;
    }

    if((one != null && two == null) || (one == null && two != null)) {
        return false;
    }

    if(one.size() != two.size()) {
        return false;
    }

    one = getSortedList(one);
    two = getSortedList(two);

    return one.equals(two);
}