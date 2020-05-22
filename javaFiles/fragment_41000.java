boolean first = true;
for ( value i : valueList ) {
    if ( i ) {
        if (first) {
            // First time do this!
            first = false;
        } else {
            // Second time onwards do this!
        }
    }
}