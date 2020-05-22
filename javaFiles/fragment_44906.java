LocalDateTime dateTime = LocalDateTime.now();

DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern("MMM d, yyyy h:mm a", new Locale("es", "ES"));

String formattedDateTime = dateTimeFormatter.format(dateTime);