constraintMatch.getConstraintPackage());
    generator.writeStringField("constraintName", constraintMatch.getConstraintName());

    generator.writeFieldName("score");
    // Delegate to PolymorphicScoreJacksonJsonSerializer
    JsonSerializer<Object> scoreSerializer = serializers.findValueSerializer(Score.class);
    scoreSerializer.serialize(constraintMatch.getScore(), generator, serializers);
    generator.writeEndObject();