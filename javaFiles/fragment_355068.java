String name="ababbaba";
    int len, count=0;

    // String match="ab";
    len=name.length();
    for(int index=0; index<=len-2;index++)
    {
        if(name.charAt(index)=='a' && name.charAt(index+1)=='b')
        {
            count++;
            System.out.println("ab is "+count+" "+"index is "+ index);
        }

    }