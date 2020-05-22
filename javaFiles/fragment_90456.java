static int indexOfLetter(String input) {
    for (int i = 0; i < input.length(); i++)
        if (Character.isLetter(input.charAt(i)))
            return i;
    return -1;
}