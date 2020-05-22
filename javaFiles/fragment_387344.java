private String getFileName1()
    {
        URL url=getClass().getResource("files/boom.txt");
        System.out.println("by getFileName1()");
        if(url!=null)
            return url.getFile().replaceAll("%20", " ");//<--- replace %20 by space charecter
        return null;
    }