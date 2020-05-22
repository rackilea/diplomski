String[] strArr1 = {"shot", "dcba"};
String[] strArr2 = {"host", "abcd"};

for(String s1 : strArr1)
{
    for(String s2 : strArr2)
    {
        System.out.printf("%nString s1: %s, String s2: %s%n", s1, s2);
        System.out.println(isAnagram(s1, s2) ?
            "Is anagram" : "Is not an anagram");
    }
}