import com.google.gson.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.lang.reflect.Type;

public class StringPropertyAdapter implements
        JsonSerializer<StringProperty>, 
        JsonDeserializer<StringProperty> {
    @Override
    public JsonElement serialize(
            StringProperty property, 
            Type type, 
            JsonSerializationContext jsonSerializationContext
    ) {
        return new JsonPrimitive(
                property.getValue()
        );
    }

    @Override
    public StringProperty deserialize(
            JsonElement json, 
            Type type, 
            JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {
        return new SimpleStringProperty(
                json.getAsJsonPrimitive().getAsString()
        );
    }
}