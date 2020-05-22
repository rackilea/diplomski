SimObject o = parse( new HashMap<>(), Arrays.asList(
    SimObject1::buildFromAttributes, SimObject2::buildFromAttributes ) );

    public SimObject parse(Map<String,String> attrs, 
    List< Function<Map<String,String>, SimObject> > factories) {
        for (Function<Map<String,String>, SimObject> f : factories) {
            SimObject o = f.apply(attrs);
            if (o != null) return o;
        } 
        throw new IllegalArgumentException("Could not create valid simobject");
     }