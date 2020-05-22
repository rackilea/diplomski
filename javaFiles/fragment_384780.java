DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM-dd-yyyy" );
LocalDate localDate = null;  
try {
    localDate = LocalDate.parse( input );
} catch ( DateTimeParseException e ) {
    // Exception means the input is not in ISO 8601 format.
    // Try the other expected format.
    try {
        localDate = LocalDate.parse( input , formatter );
    } catch ( DateTimeParseException e ) {
        // FIXME: Unexpected input fit neither of our expected patterns.
    }
}