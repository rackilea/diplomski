public int makeDecimal(String value, int base) {
    // exit from recursion
    if (value.length() < 1) 
        return 0;

    //parsing last character of string
    int charValue = Integer.parseInt(value.substring(value.length() - 1), base);

    //calling recursion for string without last character
    return makeDecimal(value.substring(0, value.length() - 1), base) * base + charValue;
}