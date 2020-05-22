public class Main {

    public static void main( String[] args ) {
        Config cfg = new Config();
        MapConfig mapConfig = new MapConfig( "things" );
        mapConfig.addMapAttributeConfig( new MapAttributeConfig( "list", ListValueExtractor.class.getName() ) );//register extractor for 'list'
        cfg.addMapConfig( mapConfig );
        HazelcastInstance instance = Hazelcast.newHazelcastInstance( cfg );
        IMap<String, List<String>> mapThings = instance.getMap( "things" );

        mapThings.put( "Joe", new ArrayList<String>() {{
            add( "apple" );
            add( "box" );
            add( "laptop" );
        }} );

        mapThings.put( "Denis", new ArrayList<String>() {{
            add( "apple" );
            add( "pencil" );
            add( "jacket" );
        }} );
        EntryObject e = new PredicateBuilder().getEntryObject();
        Predicate withApple = Predicates.equal( "list[any]", "apple" );
        Predicate withLaptop = Predicates.equal( "list[any]", "laptop" );

        List<String> usersWithApple = mapThings.entrySet( withApple ).stream().map( Map.Entry::getKey ).collect( Collectors.toList() );
        List<String> usersWithLaptop = mapThings.entrySet( withLaptop ).stream().map( Map.Entry::getKey ).collect( Collectors.toList() );

        System.out.println( usersWithApple ); // [Joe, Denis]
        System.out.println( usersWithLaptop ); // [Joe]
    }
}