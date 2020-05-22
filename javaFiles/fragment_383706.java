DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

ObjectMapper mapper = Jackson2ObjectMapperBuilder
            .json()       
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) 
            .modules(new JavaTimeModule())
            .dateFormat(dateFormat)
            .build();