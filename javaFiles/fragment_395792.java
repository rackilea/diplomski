String[] tests = {
        "foo.bar.txt",       // [foo bar.txt]
        "foo...bar.foo.txt", // [foo bar foo.txt]
        "........",          // [.]
        "...x...dat",        // [x.dat]
        "foo..txt",          // [foo.txt]
        "mmm....yummy...txt" // [mmm yummy.txt]
    };
    for (String test : tests) {
        int k = test.lastIndexOf('.');          
        String s = test.substring(0, k).replaceAll("\\.+", " ").trim()
           + test.substring(k);
        System.out.println("[" + s + "]");
    }