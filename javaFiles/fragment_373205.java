String input = "2017-08-01T15:43:45+0530";

DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

OffsetDateTime offsetDateTime = OffsetDateTime.parse(input, parser);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

System.out.println(offsetDateTime.format(formatter)); // 2017-08-01T15:43:45+05:30