LocalDate localDate2;
    Date d2 = fooEntity.getFooDate();
    if (d2 instanceof java.sql.Date) {
        localDate2 = ((java.sql.Date) fooEntity.getFooDate()).toLocalDate();
    } else {
        localDate2 = d2.toInstant()
                .atZone(ZoneId.of("Africa/El_Aaiun"))
                .toLocalDate();
    }