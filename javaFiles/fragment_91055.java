String inputDateTimeWithZone = "2017/09/25 16:18:15.099 -0400 EDT";
    DateTimeFormatter formatterWithOffsetAndZone 
            = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss.SSS xx zzz", Locale.ENGLISH);
    ZonedDateTime zdt = ZonedDateTime.parse(inputDateTimeWithZone,
            formatterWithOffsetAndZone);
    OffsetDateTime odt = OffsetDateTime.parse(inputDateTimeWithZone, 
            formatterWithOffsetAndZone);
    if (! zdt.toOffsetDateTime().equals(odt)) {
        System.err.println("Offset does not match: is " + odt.getOffset()
                + ", but time zone " + zdt.getZone() + " implies offset " + zdt.getOffset());
    }