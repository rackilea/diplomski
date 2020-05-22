PrintWriter out;
    System.out.println(s1);
    out = new PrintWriter("F:/sem5/algorithm/out.txt");
    try
    {
       out.write(s1);
       System.out.println(s1);
    }
    finally
    {
       out.close();
    }