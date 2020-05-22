List< ZoneId > zones = 
    List.of( 
            ZoneId.of( "Europe/Paris" ) , 
            ZoneId.of( "America/New_York" ) , 
            ZoneId.of( "Asia/Kolkata" ) 
    ) 
;
for( ZoneId z : zones ) {
    workManager.scheduleForZone( z ) ;
}