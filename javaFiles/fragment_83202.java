if ( insertValue instanceof ZonedDateTime ) {
    if ( insertValue != null ) {
        Timestamp convertedDate = Timestamp.from( ((ZonedDateTime) insertValue).toInstant() );
        preparedStatement.setTimestamp( paramNumber, convertedDate );
    } else {
        preparedStatement.setNull ( paramNumber, Types.TIMESTAMP );
    }
}