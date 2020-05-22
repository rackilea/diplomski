ObjectMapper mapper = new ObjectMapper();
mapper.setVisibilityChecker(getSerializationConfig().getDefaultVisibilityChecker()
.withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
.withFieldVisibility(JsonAutoDetect.Visibility.NONE)
.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
.withSetterVisibility(JsonAutoDetect.Visibility.NONE));