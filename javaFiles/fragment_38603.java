Map< LocalDate, List< LocalTime > > result2 = list.stream()
    .map( CustomDate::getDatetime )
    .collect(
        HashMap::new,
        (map,date) -> {
             map.putIfAbsent( date.toLocalDate( ), new ArrayList<>(   )).add( date.toLocalTime( ) );
        },
        (map1, map2) -> {
            map2.forEach( (date,timeList) -> {
                map1.merge( date, timeList, ( l1, l2 ) -> {
                    l1.addAll( l2 );
                    return l1;
                } );
            }); 
        }
    );