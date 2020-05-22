class CustomDateCollector implements Collector<CustomDate, Map< LocalDate, List< LocalTime > >, Map< LocalDate, List< LocalTime > >> {

    @Override
    public Supplier< Map< LocalDate, List< LocalTime > > > supplier( ) {

        return HashMap::new;
    }

    @Override
    public BiConsumer< Map< LocalDate, List< LocalTime > >, CustomDate > accumulator( ) {
        int goodStartUsingProblemKnowledge = 30;
        return (map, customDate) -> map.putIfAbsent( customDate.getDatetime().toLocalDate(), new ArrayList<>( goodStartUsingProblemKnowledge) )
                                       .add(  customDate.getDatetime().toLocalTime() );
    }

    @Override
    public BinaryOperator< Map< LocalDate, List< LocalTime > > > combiner( ) {

        return (map1, map2) -> {
                map2.forEach( (date,timeList) -> {
                    map1.merge( date, timeList, ( list1, list2 ) -> {
                        list1.addAll( list2 );
                        return list1;
                    } );
                });
                return map1;
        };
    }

    @Override
    public Function< Map< LocalDate, List< LocalTime > >, Map< LocalDate, List< LocalTime > > > finisher( ) {

        return Function.identity();
    }

    @Override
    public Set< Characteristics > characteristics( ) {

        return Collections.unmodifiableSet( EnumSet.of( IDENTITY_FINISH, UNORDERED,CONCURRENT) );
    }

    public static CustomDateCollector customDateCollector(){
        return new CustomDateCollector();
    }
}