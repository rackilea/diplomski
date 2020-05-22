for(int i = 0; i<=l-1; i++)
    {
        for(int j = i+1; j<=l-1; j++)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                s = s.deleteCharAt(j);

            l--;
        }
        else
            continue;
    }