@Bean
    public ConsumerFactory<String, AssessmentAttemptDetailsEntity> assessmentAttemptDetailsEntityConsumerFactory() {
            JsonDeserializer<AssessmentAttemptDetailsEntity> 
            deserializer = new JsonDeserializer<>();
            deserializer.addTrustedPackages("com.lte.assessment.assessments");//your package
        return new DefaultKafkaConsumerFactory(config,deserializer);
    }