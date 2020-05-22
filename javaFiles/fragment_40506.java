DateTimeFormatter formatter = DateTimeFormatter
    .ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
    .withZone(ZoneOffset.UTC);
Instant now = Instant.now();
String text = formatter.format(now); 
System.out.println(text);