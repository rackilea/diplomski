long cnt = 0;
for (int i = 0; i < (s.length() - 1); i++)
    if (s.charAt(i) == c)
        for (int j = (i + 1); j < s.length(); j++)
            if (s.charAt(j) == c)
                cnt++;
return cnt;