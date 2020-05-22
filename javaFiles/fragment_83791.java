void subStrings(String s)
    {
        if(s == null || s.length() == 0 || s.charAt(0) == 'A' || s.charAt(0) == 'a')
        {
            System.out.println("Cannot shorten substring.");
            return;
        }
        if(s.length() != 1)
        {
            String subString = "";
            int i = 0;
            while(s.charAt(i) != 'A' && s.charAt(i) != 'a' && i < s.length() - 1)//bad line
            {
                subString += s.charAt(i);
                i++;
            }


            if(subString.equals(""))
                subStrings(s.substring(i));
            else
            {
                System.out.println(subString);
                subStrings(s.substring(0, i));
            }
        }
    }