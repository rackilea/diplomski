val format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

val javaTimeModule = JavaTimeModule();
javaTimeModule.addSerializer(LocalDateTime.class, LocalDateTimeSerializer(format));
javaTimeModule.addSerializer(ZonedDateTime.class, ZonedDateTimeSerializer(format));
mapper.registerModule(javaTimeModule);