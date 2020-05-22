CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
            CodecRegistries.fromCodecs(new LocalDateCodec()),
            CodecRegistries.fromProviders(
                    new RaCodecProvider(),
                    new DutyBlockCodecProvider(),
                    new ScheduledDutyCodecProvider()),
            MongoClient.getDefaultCodecRegistry());  
    MongoClientOptions options = MongoClientOptions.builder()
            .codecRegistry(codecRegistry).build();
    mongoClient = new MongoClient(new ServerAddress(), options);
    db = mongoClient.getDatabase("DutySchedulerDB");