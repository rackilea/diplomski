List< LocalDateTime > slots = new ArrayList<>() ;
LocalDateTime ldt = start ;
while (
    ldt.isBefore( stop ) 
) {
    slots.add( ldt ) ;
    // Prepare for the next loop. 
    ldt = ldt.plusHours( 1 ) ;
}