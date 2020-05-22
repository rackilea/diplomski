public int getCount(String pattern){
    int occerenceOfPattern = 0;
    for (int i = 0; i < strand.length(); i++) { // Updated check
        if((i + pattern.length()) >= strand.length()) // New condition to avoid exception
            break;
        if (strand.substring(i, i + pattern.length()) == pattern) {
            occerenceOfPattern++;
        }
    }
    return occerenceOfPattern;
}