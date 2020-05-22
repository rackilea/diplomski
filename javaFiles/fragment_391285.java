public LocalDate convert(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
}

// if your Date has no toInstant method, try this:
public LocalDate convert(Date date) {
    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
}