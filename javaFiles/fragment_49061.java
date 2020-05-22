outerloop:
for( String country : countries){
     for( String segment : split_str) {
        if( country.startsWith( segment ) ) {
            // do something here when the segment has been detected
            break outerloop;
        }
     }
}