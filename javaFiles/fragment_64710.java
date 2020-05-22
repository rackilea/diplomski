public static boolean endsWith(String input, String substring)
    {
        if (input == null)
            input = "";
        if (substring == null)
            substring = "";
        int index = input.indexOf(substring);
        if (index == -1)
            return false;
        if (index == 0 && substring.length() == 0)
            return true;
        return (index == input.length() - substring.length());
}