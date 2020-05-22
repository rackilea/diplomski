public static Instant toInstant(final String timeStr){
    final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH[:mm[:ss[ SSSSSSSS]]]")
            .withZone(ZoneId.of("UTC"));
    try {
        return Instant.from(formatter.parse(timeStr));
    }catch (DateTimeException e){
        final DateTimeFormatter formatter2 = DateTimeFormatter
                .ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.of("UTC"));
        return LocalDate.parse(timeStr, formatter2).atStartOfDay().atZone(ZoneId.of("UTC")).toInstant();
    }
}