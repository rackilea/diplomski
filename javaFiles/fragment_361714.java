String S = "alfabet";
            String odd="";String even="";
            for(int c=0;c<S.length();c++)
            {
                if(c%2==0)odd+=S.charAt(c);
                else even+=S.charAt(c);
            }