private boolean containsDigit3(int i) {
    //indexOf returns position of character '3' in String that
    //represents the number i. If '3' is not found it returns -1
    //so indexOf('3') >= 0 is another way of saying "contains digit 3"
    return Integer.toString(i).indexOf('3') >= 0;
}

private boolean isMultipleOf3(int i) {
    return i%3 == 0;
}