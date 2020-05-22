public static JsonParser getJsonParser() {
    if (ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper", null)) {
        return new JacksonJsonParser();
    }
    if (ClassUtils.isPresent("com.google.gson.Gson", null)) {
        return new GsonJsonParser();
    }
    if (ClassUtils.isPresent("org.yaml.snakeyaml.Yaml", null)) {
        return new YamlJsonParser();
    }

    return new BasicJsonParser();
}