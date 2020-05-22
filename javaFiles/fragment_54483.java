public static void main(String[] args)
{
    String str = "christian";
    String new_str = "";

    for (int i = 0; i < str.length(); i++) {
        new_str += str.charAt(i);
        if (isVowel(str.charAt(i))) // If is a vowel
            new_str += "ub";
    }
    System.out.println(new_str);
}

private static boolean isVowel(char c)
{
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        return true;
    return false;
}