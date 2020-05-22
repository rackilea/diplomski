String c = "qwe";   // string literal qwe goes into runtime cache
    String d = c.substring(1); // runtime string "we" is created
    d.intern();         // intern "we"; it has not been seen 
                        // yet so this version goes into the cache
    String e = "we";    // now we see the string literal, but
                        // a value is already in the cache and so 
                        // the same instance as d is returned 
                        // (see ref below)

    System.out.println( e == d );  // returns true