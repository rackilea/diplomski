parser.nextToken();
    if (!"constraintName".equals(parser.getCurrentName())) {
        throw new IllegalStateException(...);
    }
    parser.nextToken();
    String constraintName = parser.getValueAsString();

    parser.nextToken();
    if (!"score".equals(parser.getCurrentName())) {
        throw new IllegalStateException(...);
    }
    parser.nextToken();
    JsonDeserializer<Object> scoreDeserializer = context.findNonContextualValueDeserializer(context.constructType(Score.class));
    Score score = (Score) scoreDeserializer.deserialize(parser, context);