LocalDate localDate = null;  
try {
    localDate = LocalDate.parse( input );  // ISO 8601 formatter used implicitly.
} catch ( DateTimeParseException e ) {
    // Exception means the input is not in ISO 8601 format.
}