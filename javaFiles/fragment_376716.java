import java.io.IOException;
import org.apache.zookeeper.ClientCnxn;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ClientCnxnAdapter extends TypeAdapter<ClientCnxn> {
    @Override
    public void write(JsonWriter writer, ClientCnxn cnxn) throws IOException {
        writer.beginObject();
        writer.name("sessionId");
        writer.value(cnxn.getSessionId());
        writer.name("timeOut");
        writer.value(cnxn.getSessionTimeout());
        writer.endObject();
    }

    @Override
    public ClientCnxn read(JsonReader in) throws IOException {
        return null;
    }
}