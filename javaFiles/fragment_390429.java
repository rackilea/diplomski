String current = "";
    String temp;
    while (needData())
    {
        Thread.sleep(5000);
        temp = getData("http://woot.com");
        if (!current.equals(temp))
        {
            System.out.println(temp);
            current = temp;
        }
    }