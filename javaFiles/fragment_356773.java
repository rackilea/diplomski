String c = "qwe";   // string literal qwe goes into runtime cache
    String d = c.substring(1); // runtime string "we" is created
    String e = "we";    // now we see the string literal, this time
                        // a value is NOT already in the cache and so 
                        // the string literal creates an object and
                        // places it into the cache
    d.intern();         // has no effect - a value already exists
                        // in the cache, and so it will return e

    System.out.println( e == d );  // returns false
    System.out.println( e == d.intern() );  // returns true
    System.out.println( e == d );  // still returns false