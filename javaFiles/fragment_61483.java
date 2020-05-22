Hello

 worl

d, my 

name 

is so

String str="Hello world, my name is something which you want to";
    for(int i=0;i<str.length();i++)
    {
        if(i%5==0 && i!=0)
        {
            System.out.println("");
        }
        System.out.print(str.charAt(i));


    }