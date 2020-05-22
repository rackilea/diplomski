List <Pattern> patterns = new ArrayList <Pattern> ();
    //Pattern currently being checked for
    patterns.add (Pattern.compile ("<a id=.dg__ct(.+?)_hpl1.>(.+?)</a>"));
    //Pattern I want to check for as well, currently not implemented
    patterns.add (Pattern.compile ("[0-9]{2}/[0-9]{2}/[0-9]{4}"));
    BufferedReader buf = null;
    List <String> matches = new ArrayList <String> ();
    try {
        URL url = new URL ("URL to be read");
        InputStream inputStream = (InputStream) url.getContent ();
        InputStreamReader isr = new InputStreamReader (inputStream);
        buf = new BufferedReader (isr);
        String str = null;
        while ((str = buf.readLine ()) != null) 
        {
            for (Pattern p : patterns) 
            {
                Matcher m = p.matcher (str);
                while (m.find ()) 
                    matches.add (m.group ());
            }
        }       
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    finally  
    {
        if (buf != null) 
            try { buf.close (); } catch (IOException ignored) { /*empty*/}
    }