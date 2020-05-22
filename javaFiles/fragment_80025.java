import static net.hugonardo.java.commons.text.StringUtils.normalizeSpace;
import static net.hugonardo.java.commons.text.StringUtils.trimToNull;

final class StringGsonTypeAdapter implements JsonDeserializer<String> {

    private static final StringGsonTypeAdapter INSTANCE = new StringGsonTypeAdapter();

    static StringGsonTypeAdapter instance() {
        return INSTANCE;
    }

    @Override
    public String deserialize(JsonElement jsonElement, Type type, 
        JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return normalizeSpace(trimToNull(jsonElement.getAsString()));
    }
}