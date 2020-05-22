new Scanner(                           // A new scanner is created
             new URL("http://example.com")  // the scanner takes a Stream 
                                            // which is obtained from a URL
          .openStream(),                    // - openStream returns the stream
       "UTF-8")                             // Now the scanner can parse the        
                                            // stream character by character
                                            // with UTF-8 encoding

     .useDelimiter("\\A")                   // Now the scanner set as 
                                            // delimiter the [Regexp for \A][1]
                                            // \A stands for :start of a string!

   .next();                                 // Here it returns the first(next) 
                                            // token that is before another
                                            // start of string. 
                                            // Which, I'm not sure 
                                            // what it will be