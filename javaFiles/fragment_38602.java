public class Dates {

    private static List< CustomDate > list = new ArrayList<>(  );

    public static void main( String[] args ) {

        Map< LocalDate, List< LocalTime > > result2 = list.stream()
            .map( CustomDate::getDatetime )
            .collect(
                HashMap::new,
                Dates::accept,
                Dates::merge
            );

    }

    private static void accept( HashMap< LocalDate, List< LocalTime > > map, LocalDateTime date ) {

        map.putIfAbsent( date.toLocalDate( ), new ArrayList<>())
           .add( date.toLocalTime( ) );
    }

    private static void merge( Map< LocalDate, List< LocalTime > > map1, Map< LocalDate, List< LocalTime > > map2 ) {

        map2.forEach( (date,timeList) -> {
            map1.merge( date, timeList, ( l1, l2 ) -> {
                l1.addAll( l2 );
                return l1;
            } );
        });

    }
}