static int indexOfLetter(String input) {
    for (int i = 0; i < input.length(); i = input.offsetByCodePoints(i, 1))
        if (Character.isLetter(input.codePointAt(i)))
            return i;
    return -1;
}