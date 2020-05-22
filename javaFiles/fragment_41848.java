@Global
public class JsonObjectBinder implements TypeBinder<JsonObject> {

    @Override
    public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType) throws Exception {
        return new JsonParser().parse(value);
    }

}