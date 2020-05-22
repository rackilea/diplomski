for (String text : new String[] {
            "1999-12-31 12:59:59",
            "1999-12-31 12:59:59 +02:00",
            "1999-12-31 12:59:59 UTC+02:00",
            "1999-12-31 12:59:59 America/Porto_Velho",
    }) {
        TemporalAccessor parsed = DATE_TIME.parse(
                text ,
                (temporal) -> {
                    // see if there is an offset or tz
                    final ZoneId zoneOrOffset = temporal.query( TemporalQueries.zone() );
                    if ( zoneOrOffset != null ) {
                        ZonedDateTime zdt = ZonedDateTime.from( temporal );
                        // EDIT: call normalized() to convert a ZoneId
                        // with constant offset, e.g., UTC+02:00, to ZoneOffset
                        if (zoneOrOffset.normalized() instanceof ZoneOffset) {
                            return zdt.toOffsetDateTime();
                        } else {
                            return zdt;
                        }
                    }

                    // otherwise it's a LocalDateTime
                    return LocalDateTime.from( temporal );
                }
        );

        System.out.format(Locale.ENGLISH, "%-30s %s%n", parsed.getClass(), parsed);
    }