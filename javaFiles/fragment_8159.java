ZoneOffset offset;
    if (offsetString == null) {
        offset = ZoneOffset.UTC;
    } else {
        offset = ZoneOffset.of(offsetString);
    }
    String formattedTimestamp = dateTime.atOffset(offset).toString();