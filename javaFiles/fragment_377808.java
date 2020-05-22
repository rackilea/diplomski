double similarity(String a, String b) {
    if(a.length() == 0) return 1;
    int numberOfSimilarities = 0;
    for(int i = 0; i < a.length(); ++i) {
        if(a.charAt(i) == b.charAt(i)) {
            ++numberOfSimilarities;
        }
    }
    return (double) numberOfSimilarities / a.length();
}