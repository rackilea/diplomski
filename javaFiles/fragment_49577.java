dateList = 
    datesList
    .stream()
    .sorted( 
        Comparator.comparingLong( e -> e.getTime() ) 
    ).collect( 
        Collectors.toList() 
    );