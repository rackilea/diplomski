public boolean allSame(ArrayList<Double> s) {
    for (int i=0; i<s.size() - 1; i++) {
        if ( s.get(i) != s.get(i+1) )
            return false;
    }
    return true;
}