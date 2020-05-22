char[] delims = {'/', ' ', '-'};
    int result = 0;
    for (char delim : delims) {
        for (int i = 0; i < hand.length(); i++) {
            if (hand.charAt(i) == delim) {
                ++result;
            }
        }
    }