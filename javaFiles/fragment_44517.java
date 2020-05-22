public boolean containsNonDigits(String digits) {
    for(int i = 0; i < digits.length(); ++i) {
        if(Character.isDigit(digits.charAt(i))) {
            continue;
        } else {
            return true;
        }
    }
    return false;
}