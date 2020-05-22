Date dateTime = new Date();

DateFormat date = new SimpleDateFormat(
        "MMM d, yyyy h:mm a", new Locale("es", "ES"));

String formattedDateTime = date.format(dateTime);