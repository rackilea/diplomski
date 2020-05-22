public static bool IsPalindrome(string s)
    {
        if(s == "") return true;

        return IsPalindrome(s, 0, s.length() - 1);
    }

    static bool IsPalindrome(string s, int start, int end)
    {
        if(s[start] == s[end])
        {
            if(start >= end) return true;

            else return IsPalindrome(s, start + 1, end - 1);
        }

        return false;
    }