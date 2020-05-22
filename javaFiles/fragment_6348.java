public static final Map<String, int[]> AGE_GROUPS;
    static{
        Map<String, int[]> otherMap = new HashMap<String, int[]>();
        otherMap.put( "10-20", new int[]{ 10, 11 } );
        otherMap.put( "20-30", new int[]{ 20, 21 } );

        AGE_GROUPS = Collections.unmodifiableMap( otherMap );

    }