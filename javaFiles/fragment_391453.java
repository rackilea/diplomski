private int count(char[] chars, int high) {
    // if high==0 we are looking at zero characters, so there are no upper-case characters:
    if (high == 0) {
        return 0 ;
    }

    if (Character.isUpperCase(chars[high-1])) {
        // if the last character we look at is upper-case, then the total
        // for this set of characters is one more than the total for the
        // set of characters omitting the last one:
        return 1 + count(chars, high-1);
    } else {
        // otherwise (the last character is not upper-case), the total
        // for this set of characters is the same as the total for the 
        // set of characters omitting the last one:
        return count(chars, high-1);
    }
}