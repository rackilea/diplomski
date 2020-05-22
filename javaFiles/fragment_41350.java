public static void main(String[] args)
{
    String s1 = "shotaabb";
    String s2 = "hostbaba";
    System.out.printf("String s1: %s, String s2: %s%n", s1, s2);
    System.out.println(isAnagram(s1, s2) ?
            "Is anagram" : "Is not an anagram");
}

static boolean isAnagram(String s1, String s2)
{
    String str1 = new String(s1);
    String str2 = new String(s2);

    // Ensures that both strings are of the same length
    if (str1.length() != str2.length())
        return false;

    int str1Len = str1.length();
    for (int i = 0; i < str1Len; i++)
    {
        int charIndex = str2.indexOf(str1.charAt(i));

        if(charIndex == -1) // Not found in str2
            return false;
        else
        {
            // Remove the character from str2
            str2 = str2.substring(0, charIndex) +
                str2.substring(charIndex + 1);
        }
    }

    return true;
}