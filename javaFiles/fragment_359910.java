String s1 = "John James Joanne Catherine Paul Steve";
    String s2 = "Ian John Catherine Paul Mike Tim Ray"; 

    String s3="";
    int checker=0;

    String[] s1_=s1.split(" ");
    String[] s2_=s2.split(" ");

    for(int i=0;i<s1_.length;i++)
    {
        for(int j=0;j<s2_.length;j++)
        {
            if(!s1_[i].equals(s2_[j]))
            {
                checker=checker+1;
            }
        }
        if(checker==s2_.length)
        {
            s3=s3+s1_[i];
        }
        checker=0;
    }

    System.out.println(s3);