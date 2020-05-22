long se = System.currentTimeMillis();
    while ((inputLine = in.readLine()) != null)
    { 
        fullline = fullline.concat(inputLine); 
        if ( System.currentTimeMillis() > se + 10000) {
             throw new IOException ();
        }
    }