String[] data = { "a short string", "a very long string to see that we get only the last 20 characters" };

    for (String s : data)
    {
        System.out.println("....:....|....:....|");
        System.out.printf("%20s\n",s.substring(Math.max(0, s.length()-20)));
    }