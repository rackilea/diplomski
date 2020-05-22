/**
 * Custom JsonAdapter for GSON to handle {@link EquationList} converstion
 * 
 * @author Yavuz Tas
 *
 */
public class EquationListJsonAdapter extends TypeAdapter<EquationList> {

    @Override
    public void write(JsonWriter out, EquationList user) throws IOException {

        // Since we do not serialize EquationList by gson we can omit this part.
        // If you need you can check
        // com.google.gson.internal.bind.ObjectTypeAdapter class
        // read method for a basic object serialize implementation

    }

    @Override
    public EquationList read(JsonReader in) throws IOException {

        EquationList deserializedObject = new EquationList();

        // type of next token
        JsonToken peek = in.peek();

        // if the json field is string
        if (JsonToken.STRING.equals(peek)) {
            String stringValue = in.nextString();
            // convert string to integer and add to list as a value
            deserializedObject.add(Integer.valueOf(stringValue));
        }

        // if it is array then implement normal array deserialization
        if (JsonToken.BEGIN_ARRAY.equals(peek)) {
            in.beginArray();

            while (in.hasNext()) {
                String element = in.nextString();
                deserializedObject.add(Integer.valueOf(element));
            }

            in.endArray();
        }

        return deserializedObject;
    }
}