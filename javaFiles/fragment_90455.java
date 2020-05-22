static int indexOfLetter(String input) {
    String regex = "[a-zA-Z]";
    //         or: "\\p{Alpha}";  // same as [a-zA-Z]
    //         or: "\\p{L}";      // all unicode letters
    Matcher m = Pattern.compile(regex).matcher(input);
    if (m.find())
        return m.start();
    return -1;
}