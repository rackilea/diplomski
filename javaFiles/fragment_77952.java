public boolean any(String[] array, String s) {
    for(String value : array) {
        if(s.equals(value)) { return true; }
    }
    return false;
}