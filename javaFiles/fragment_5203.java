byte[] b1 = "abc".getBytes();
    byte[] b2 = "abc".getBytes();
    if(b1 == b2)
    {
        System.out.println("Equal Not possible");//Not this
    }
    if(Arrays.equals(b1, b2))
    {
        System.out.println("Equal possible");//Gets printed
    }