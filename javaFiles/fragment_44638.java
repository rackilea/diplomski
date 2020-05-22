// NOTE I am just copying over your code and not worrying about the algorithm's correctness

boolean valid = true;
if (potentialpassword.length() < 6) {
    valid = false;
} else {
    char x;
    int count = 0;
    for (int i = 0; i < potentialpassword.length(); i++) {
        x = potentialpassword.charAt(i);
        if (SPECIAL_CHARACTERS.indexOf(String.valueOf(x)) >= 1) {
            valid = true;
            break;
        }
        if (Character.isWhitespace(x)) {
            valid = false;
            break;
        }
        if (Character.isDigit(x)) {
            count++;
        } else if (count < 1) {
            valid = false;
            break;
        }
    }
    return valid;
}