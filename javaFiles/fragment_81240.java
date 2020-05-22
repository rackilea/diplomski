Map<String,String[]> s = new HashMap<String,String[]>();
    s.put("10",new String[]{"Blah","Blah2"}); //to put the String data array


    if(s.get("10") != null)
    {
        String s1 = s.get("10")[0]; //to get the data in index 0 without iterating.
        String s2 = s.get("10")[1]; //to get the data in index 1 without iterating.
    }