// GSON library for JSON
@Override
public String toString(){
    return new com.google.gson.Gson().toJson(this);
}

// Jackson libabry for JSON/YAML
@Override
public String toString() {
    try {
        return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
        e.printStackTrace();
    }
    return null;
}