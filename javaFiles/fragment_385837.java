JavaTimeModule timeModule = new JavaTimeModule();
    timeModule.addSerializer(LocalDate.class, 
        new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
    timeModule.addSerializer(LocalDateTime.class, 
        new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    objectMapper.registerModule(timeModule);