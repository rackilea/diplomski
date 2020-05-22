import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import com.google.gson.stream.JsonReader;

public class TransportJSonReader implements Iterator<Transport> {

protected JsonReader jsonReader;

public TransportJSonReader(Reader reader) throws IOException
{
    jsonReader = new JsonReader(reader);
    jsonReader.beginObject();

    //columns
    jsonReader.nextName();
    jsonReader.skipValue();

    //data
    jsonReader.nextName();
    jsonReader.beginArray();

}

@Override
public boolean hasNext() {
    try {
        return jsonReader.hasNext();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

@Override
public Transport next() {
    if (!hasNext()) throw new IllegalStateException();

    try {
        jsonReader.beginArray();
        String name = jsonReader.nextString();
        String description = jsonReader.nextString();
        String id = jsonReader.nextString();
        jsonReader.endArray();
        return new Transport(id, name, description);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

@Override
public void remove() {
    throw new UnsupportedOperationException();
}

}