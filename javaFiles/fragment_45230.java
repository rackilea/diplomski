HashMap<String, TreeMap<Double, String>> words = new HashMap<String, TreeMap<Double,String>>();

    TreeMap<Double, String> appleMap = new TreeMap<Double, String>();
    appleMap.put( 0.2d, "cake");
    appleMap.put( 1.0d, "sauce");
    words.put( "apple", appleMap );

    TreeMap<Double, String> transformerMap = new TreeMap<Double, String>();
    transformerMap.put( 0.95d, "movie");
    transformerMap.put( 0.975d, "cat");
    transformerMap.put( 1.0d, "dog");
    words.put( "transformer", transformerMap );