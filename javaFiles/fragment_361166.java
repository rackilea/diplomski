org.threeten.bp.OffsetDateTime odt = 
    OffsetDateTime.parse(
        "2012-02-12T09:08:13.123456-0400",
        org.threeten.bp.format.DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ssZ" )  // Specify pattern as workaround for Java 8 bug in failing to parse if optional colon is not present.
    )
;