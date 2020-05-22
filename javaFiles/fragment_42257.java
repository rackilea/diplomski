List<Integer> li = Arrays.asList(1,2,3,45,678); 
        String Str =li.toString();
        char [] ch = new char[Str.length()];
        for(int i=0;i<Str.length();i++)
        {
         ch[i] =    Str.charAt(i);
        }
        for(char cc:ch)
        {        
            System.out.print(cc);
        }