Set < String > names = ZoneId.getAvailableZoneIds();  // Get a collection of all known time zones’ names.
    for ( String name : names )                           // Loop each name.
    {
        ZoneId z = ZoneId.of( name );                     // Instantiate a `ZoneId` for that zone name.
        ZoneRules rules = z.getRules();                   // Get the history of past, present, and future changes in offset used by the people of this particular region (time zone).
        ZoneOffset o = rules.getOffset( instant );        // Get the offset-from-UTC in effect at this moment for the people of this region.
        if( o.equals( offset )) {                         // Compare this particular offset to see if it is the same number of hours, minutes, and seconds as our target offset.
            hits.add( z );                                // If we have a hit, add to our collection of `ZoneId` objects.
        }
    }