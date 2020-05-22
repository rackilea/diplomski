String str="Hello world, my name is something which you want to";
    for(int i=0,j=0;i<str.length();)
    {
        if(j<str.length() && (str.length()-j)>5)
        {j=i+5;}
        else
        {j=str.length();}
        System.out.println(str.substring(i,j));
        i+=5;
    }