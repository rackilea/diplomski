import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Optional;

public class RecipeSerializer extends StdSerializer<Recipe> {

    protected RecipeSerializer() {
        this(null);
    }

    protected RecipeSerializer(Class<Recipe> t) {
        super(t);
    }

    @Override
    public void serialize(Recipe recipe, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeStringField("name", recipe.getName());
        gen.writeStringField("author", Optional.ofNullable(recipe.getAuthor().getUsername()).orElse("null"));
        gen.writeStringField("ingridients", recipe.getIngridients());

        gen.writeEndObject();
    }
}