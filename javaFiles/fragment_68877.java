System.out.println("********************"
            + OffsetDateTime.parse("20140726080320+0400",
                                DateTimeFormatter.ofPattern("uuuuMMddHHmmssZ")
                                        .withChronology(IsoChronology.INSTANCE)
                                        .withResolverStyle(STRICT))
                        .toEpochSecond());