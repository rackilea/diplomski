static boolean hasSubstring(Collection<String> c, String substring) {
    for(String s : c) {
        if(s.contains(substring))
            return true;
    }
    return false;
}