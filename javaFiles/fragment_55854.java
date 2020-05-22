LocalDateTime ldt = LocalDateTime.of ( 2019 , 03 , 31 , 13 , 0 , 0 , 0 );
System.out.println ( "Offsets for: " + ldt );

List < ZoneId > zones = 
        List.of ( 
            ZoneId.of ( "Australia/Adelaide" ) , 
            ZoneId.of ( "Australia/Broken_Hill" ) 
        )
;
for ( ZoneId zone : zones )
{
    ZoneOffset offset = zone.getRules ().getOffset ( ldt );
    System.out.println ( "zone: " + zone.toString () + " has offset: " + offset.toString () );
}