private static boolean validChars(String dna) {
    for (char c: dna.toCharArray()) {
        if((c != 'C') && (c != 'G') && (c != 'T') && (c != 'A')) {
            return false;
        }
    }
    return true;
}